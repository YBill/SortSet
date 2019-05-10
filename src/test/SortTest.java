package test;

import javaimpl.*;

public class SortTest {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int n = 1000;

        // 生成随机数组
        int[] data = SortTestHelper.INSTANCE.generateRandomArray(n, 0, n);

        int[][] arr = new int[10][n];

        // 拷贝新数组
        for (int i = 0; i < 10; i++) {
            arr[i] = SortTestHelper.INSTANCE.copyArray(data, n);
        }

        SortTestHelper.INSTANCE.testSort("归并排序", () -> {
            MergeSort mergeSort = new MergeSort();
            mergeSort.sort(arr[0]);
            return arr[0];
        });

        SortTestHelper.INSTANCE.testSort("希尔排序", () -> {
            ShellSort shellSort = new ShellSort();
            shellSort.sort(arr[1]);
            return arr[1];
        });

        SortTestHelper.INSTANCE.testSort("插入排序", () -> {
            InsertSort insertSort = new InsertSort();
            insertSort.sort(arr[2]);
            return arr[2];
        });
        SortTestHelper.INSTANCE.checkSortOrder(InsertSort.class.getName(), arr[2], n);

        SortTestHelper.INSTANCE.testSort("堆  排序", () -> {
            HeapSort heapSort = new HeapSort();
            heapSort.sort(arr[3]);
            return arr[3];
        });

        SortTestHelper.INSTANCE.testSort("选择排序", () -> {
            SelectSort selectSort = new SelectSort();
            selectSort.sort(arr[4]);
            return arr[4];
        });

        SortTestHelper.INSTANCE.testSort("快速排序", () -> {
            QuickSort quickSort = new QuickSort();
            quickSort.sort(arr[5]);
            return arr[5];
        });

        SortTestHelper.INSTANCE.testSort("冒泡排序", () -> {
            BubbleSort bubbleSort = new BubbleSort();
            bubbleSort.sort(arr[6]);
            return arr[6];
        });

        SortTestHelper.INSTANCE.testSort("桶  排序", () -> {
            BucketSort bucketSort = new BucketSort();
            bucketSort.sort(arr[7]);
            return arr[7];
        });

        SortTestHelper.INSTANCE.testSort("计数排序", () -> {
            CountSort countSort = new CountSort();
            countSort.sort(arr[8]);
            return arr[8];
        });

        SortTestHelper.INSTANCE.testSort("基数排序", () -> {
            RadixSort radixSort = new RadixSort();
            radixSort.sort(arr[9]);
            return arr[9];
        });

    }
}
