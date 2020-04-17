package main.java.algorythms;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        int[] dpl = new int[arr.length];
        for (int i = 1; i < arr.length; i = i << 1) {
            int left = 0;
            int right = left + i;
            while (left < arr.length) {
                merge(left, right - 1, right, Math.min(right + i - 1, arr.length - 1), arr, dpl);
                left += 2*i;
                right += 2*i;
            }
            int[] tmp = arr;
            arr = dpl;
            dpl = tmp;
        }
        return arr;
    }

    static void merge(int a, int b, int c, int d, int[] source, int[] target) {
        int pos = a;
        while (a <= b && c <= d) {
            if (source[a] < source[c]) {
                target[pos++] = source[a++];
            } else {
                target[pos++] = source[c++];
            }
        }
        while (a <= b) {
            target[pos++] = source[a++];
        }
        while (c <= d) {
            target[pos++] = source[c++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 9, 2};
        Arrays.stream(mergeSort(arr)).forEach(System.out::println);
    }
}
