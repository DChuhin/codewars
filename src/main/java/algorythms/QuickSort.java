package main.java.algorythms;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
        return arr;
    }

    static int partition(int a, int b, int[] arr) {
        while (a != b) {
            if (Math.signum(arr[b] - arr[a]) != Math.signum(b - a)) {
                swap(a, b, arr);
                int tmp = a;
                a = b;
                b = tmp;
            } else {
                b += Math.signum(a - b);
            }
        }
        return a;
    }

    static void qsort(int[] arr, int a, int b) {
        if (b - a < 1) {
            return;
        }
        int p = partition(a, b, arr);
        qsort(arr, a, p - 1);
        qsort(arr, p + 1, b);
    }

    static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 2};
        Arrays.stream(quickSort(arr)).forEach(System.out::println);
    }

}
