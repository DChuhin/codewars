package main.java;

/**
 * converts long (32 bit) to IP address in string representation
 */
public class IpKata {
    public static String longToIP(long ip) {
        StringBuilder builder = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            builder.append((ip / (long) Math.pow(256, i)) % 256).append(".");
        }
        return builder.substring(0, builder.length() - 1);
    }
}
