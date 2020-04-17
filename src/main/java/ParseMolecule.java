package main.java;

import java.util.Map;
import java.util.HashMap;

/**
 * counts number of atoms per element in chemical formula
 */
public class ParseMolecule {

    static class Context {
        StringBuilder element = new StringBuilder();
        StringBuilder number = new StringBuilder();
        Context parentContext;
        Map<String, Integer> container = new HashMap<>();
        char bracketSymbol = ' ';
        boolean closeBracketDetected = false;

        void flushToParent() {
            int numberToAdd = number.length() > 0 ? Integer.parseInt(number.toString()) : 1;
            container.forEach((key, value) -> parentContext.container.merge(key, value * numberToAdd, Integer::sum));
        }

        void flushToContainer() {
            if (element.length() > 0) {
                String elementString = element.toString();
                if (!elementString.matches("[A-Z][a-z]?")) {
                    throw new IllegalArgumentException();
                }
                int numberToAdd = number.length() > 0 ? Integer.parseInt(number.toString()) : 1;
                container.merge(elementString, numberToAdd, Integer::sum);
                element = new StringBuilder();
                number = new StringBuilder();
            }
        }
    }

    public static Map<String, Integer> getAtoms(String formula) {
        Context currentContext = new Context();
        for (char c : formula.toCharArray()) {
            if (currentContext.closeBracketDetected && !(c >= '1' && c <= '9')) {
                currentContext.flushToParent();
                currentContext = currentContext.parentContext;
                if (currentContext == null) {
                    throw new IllegalArgumentException();
                }
            }
            if (c == '(' || c == '[' || c == '{') {
                currentContext.flushToContainer();
                Context bracketContext = new Context();
                bracketContext.parentContext = currentContext;
                bracketContext.bracketSymbol = c;
                currentContext = bracketContext;
            }
            if (c == ')' || c == ']' || c == '}') {
                if ((currentContext.bracketSymbol == '(' && c != ')') ||
                        (currentContext.bracketSymbol == '[' && c != ']') ||
                        (currentContext.bracketSymbol == '{' && c != '}') ||
                        (currentContext.parentContext == null)
                ) {
                    throw new IllegalArgumentException();
                }
                currentContext.flushToContainer();
                currentContext.closeBracketDetected = true;
            }
            if (c >= 'A' && c <= 'Z') {
                currentContext.flushToContainer();
                currentContext.element.append(c);
            }
            if (c >= 'a' && c <= 'z') {
                currentContext.element.append(c);
            }
            if (c >= '1' && c <= '9') {
                currentContext.number.append(c);
            }
        }
        if (currentContext.closeBracketDetected) {
            currentContext.flushToParent();
            currentContext = currentContext.parentContext;
            if (currentContext == null) {
                throw new IllegalArgumentException();
            }
        }
        currentContext.flushToContainer();
        if (currentContext.parentContext != null) {
            throw new IllegalArgumentException();
        }
        return currentContext.container;
    }

    public static void main(String[] args) {
        System.out.println(ParseMolecule.getAtoms("MgOH)2"));
    }
}
