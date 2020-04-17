package main.java.patterns;

/**
 * Украшаем печать линией, также круто чейнить декораторы (вложенные)
 */
public class Decorator {
    public static void main(String[] args) {
        PrintInterface printInterface = new LineDecorator(new Printer("Hello"));
        printInterface.print();
    }
}

interface PrintInterface {
    void print();
}

class Printer implements PrintInterface {
    String val;

    public Printer(String val) {
        this.val = val;
    }

    @Override
    public void print() {
        System.out.println(val);
    }
}

abstract class AbstractDecorator implements PrintInterface {
    PrintInterface printInterface;

    public AbstractDecorator(PrintInterface printInterface){
        this.printInterface = printInterface;
    }
}

class LineDecorator extends AbstractDecorator {

    public LineDecorator(PrintInterface printInterface) {
        super(printInterface);
    }

    @Override
    public void print() {
        System.out.println("---------");
        printInterface.print();
    }
}
