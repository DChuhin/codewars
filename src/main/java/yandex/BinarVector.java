package main.java.yandex;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarVector {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int max = 0;
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (reader.readLine().equals("1")) {
                current++;
                if (current > max) {
                    max = current;
                }
            } else {
                current = 0;
            }
        }
        System.out.println(max);
    }
}
