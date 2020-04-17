package main.java;

/**
 * converts number of seconds into human readable view
 */
public class TimeFormatter {

    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";
        String[] names = {"year", "day", "hour", "minute", "second"};
        int[] vals = {
                seconds / (3600 * 24 * 365),
                (seconds % (3600 * 24 * 365)) / (3600 * 24),
                (seconds % (3600 * 24)) / 3600,
                (seconds % 3600) / 60,
                seconds % 60,
        };
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            if (vals[i] == 0) continue;
            builder.append(vals[i]).append(' ').append(names[i]);
            if (vals[i] > 1) builder.append('s');
            builder.append(", ");
        }
        int last = builder.lastIndexOf(", ");
        builder.replace(last, last + 2, "");
        last = builder.lastIndexOf(", ");
        if (last > 0) {
            builder.replace(last, last + 2, " and ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(476457547));
    }
}