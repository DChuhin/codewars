package main.java.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class Brackets {

        private static char[] path;

        static void visit(char bracket, int opened, int openedNow, int depth, int n) {
            path[depth] = bracket;
            int nextOpened = opened;
            int nextOpenedNow;
            if (bracket == '(') {
                nextOpened = opened + 1;
                nextOpenedNow = openedNow + 1;
            } else {
                nextOpenedNow = openedNow - 1;
            }
            if (opened == n && openedNow == 0) {
                for (int i = 0; i < depth + 1; i++) {
                    System.out.print(path[i]);
                }
                System.out.print('\n');
                return;
            }
            if (nextOpened < n) {
                visit('(', nextOpened, nextOpenedNow, depth + 1, n);
            }
            if (nextOpened == n) {
                for (int i = 0; i < depth + 1; i++) {
                    System.out.print(path[i]);
                }
                while (nextOpenedNow-- > 0) {
                    System.out.print(')');
                }
                System.out.print('\n');
            } else {
                if (nextOpenedNow > 0) {
                    visit(')', nextOpened, nextOpenedNow, depth + 1, n);
                }
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            if (n == 0) {
                return;
            }
            path = new char[2 * n];
            visit('(', 0, 0,0, n);
        }
    }