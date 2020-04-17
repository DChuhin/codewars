package main.java.yandex;


import java.io.*;

public class DuplicateRemoval {

    private static BufferedReader reader;

    private static String readLine() throws IOException {
        int i = reader.read();
        if (i == -1) return null;
        StringBuilder builder = new StringBuilder();
        while (i != '\n' && i != -1) {
            builder.append((char) i);
            i = reader.read();
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

        if (readLine().equals("0")) {
            return;
        }
        String previous = readLine();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream("output.txt")));
        writer.write(previous);
        String e;
        while ((e = readLine()) != null) {
            if (!e.equals(previous)) {
                previous = e;
                writer.write(e);
            }
        }
        writer.close();
    }
}
