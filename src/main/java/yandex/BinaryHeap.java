package main.java.yandex;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinaryHeap {

    private int[] heap = new int[DEFAULT_CAPACITY]; // 0|1 2|3 4 5 6|7 8 9 10 11 12 13 14
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 8;

    public BinaryHeap() {
    }

    public BinaryHeap(int[] init) {
        heap = init;
        size = heap.length;
        for (int i = size - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int leftInd = 2 * i + 1;
        int rightInd = 2 * i + 2;
        if (rightInd <= size - 1) {
            int left = heap[leftInd];
            int right = heap[rightInd];
            int max = left > right ? leftInd : rightInd;
            if (heap[i] < heap[max]) {
                swap(i, max);
                heapify(max);
            }
        } else if (leftInd == size - 1 && heap[i] < heap[leftInd]) {
            swap(i, leftInd);
        }
    }

    public void add(int key) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        int i = size++;
        heap[i] = key;
        while (i > 0 && heap[(i - 1) / 2] < heap[i]) {
            swap(i / 2, i);
            i /= 2;
        }
    }

    private void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public int getMax() {
        int max = heap[0];
        swap(0, --size);
        heapify(0);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 15, 33, 6, 9, 7, 8};
        BinaryHeap heap = new BinaryHeap();
        IntStream.of(arr).forEach(heap::add);
        System.out.println(heap.getMax());
        System.out.println(heap.getMax());
        heapSort(arr);
    }

    private static void heapSort(int [] arr) {
        BinaryHeap heap = new BinaryHeap(arr);
        for (int i = 0; i< arr.length; i++) {
            System.out.print(heap.getMax() + " ");
        }
    }

}
// 33|15 7|8 9 2 6
// 33|15 9|6 2 7 8 -> 15|8 9|6 2 7
