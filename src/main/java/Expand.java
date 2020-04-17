package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

/**
 * expands (ax+b)^n
 */
public class Expand {


    private static long stringToLong(String str) {
        return str.equals("") ? 1 : str.equals("-") ? -1 : Long.parseLong(str);
    }

    private static String intToString(long i, long k) {
        if (i == 1) {
            return k == 0 ? "" : "+";
        }
        if (i == -1) {
            return "-";
        }
        if (i > 0) {
            return k == 0 ? "" + i : "+" + i;
        }
        return "" + i;
    }

    private static long factor(long i) {
        return LongStream.rangeClosed(1, i).reduce(1, (i1, i2) -> i1 * i2);
    }

    private static long getBinomCoeficient(long k, long n) {
        return factor(n) /
                (factor(k) * factor(n - k));
    }

    public static String expand(String expr) {
        Pattern p = Pattern.compile("\\((-?\\d*)([a-z])([+\\-]\\d+)\\)\\^(\\d+)");
        Matcher m = p.matcher(expr);
        if (m.matches()) {
            long a = stringToLong(m.group(1));
            String x = m.group(2);
            long b = stringToLong(m.group(3));
            long n = Integer.parseInt(m.group(4));
            if (n == 0) {
                return "1";
            }
            return LongStream.rangeClosed(0, n).collect(StringBuilder::new, (str, k) -> {
                long ak = (long) Math.pow(a, n - k);
                long bk = (long) Math.pow(b, k);
                String c = intToString(ak * bk * getBinomCoeficient(k, n), k);
                if (!c.equals("0")) {
                    str.append(c);
                    if (n - k > 0) {
                        str.append(x);
                        if (n - k > 1) {
                            str.append("^").append(n - k);
                        }
                    } else if (c.equals("+") || c.equals("-")) {
                        str.append(1);
                    }
                }
            }, StringBuilder::append).toString();
        }
        return "1";
    }

    public static void main(String[] args) {
        String a = expand("(y+30517578125)^15");
        System.out.println(a);
    }
}
