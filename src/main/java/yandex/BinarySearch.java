package main.java.yandex;

public class BinarySearch {

    static int binarySearch(int[] arr, int searched) {
        int a = 0;
        int b = arr.length - 1;
        while (b >= a) {
            //if (searched < arr[a] || searched > arr[b]) return -1;
            int c = a + (b - a) / 2;
            if (arr[c] == searched) return c;
            if (arr[c] < searched) {
                a = c + 1;
            } else {
                b = c - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8, 12, 15, 22};
        System.out.println(binarySearch(arr, 10));
    }
}
