package test;

import javaimpl.*;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        int[] data = {10, 20, 5, 16, 15, 1, 30, 45, 23, 9};

        System.out.print("原始数据：");
        System.out.println(Arrays.toString(data));

        System.out.print("冒泡排序：");
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.sort(data)));

        System.out.print("选择排序：");
        SelectSort selectSort = new SelectSort();
        System.out.println(Arrays.toString(selectSort.sort(data)));

        System.out.print("插入排序：");
        InsertSort insertSort = new InsertSort();
        System.out.println(Arrays.toString(insertSort.sort(data)));

        System.out.print("希尔排序：");
        ShellSort shellSort = new ShellSort();
        System.out.println(Arrays.toString(shellSort.sort(data)));

        System.out.print("归并排序：");
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(data)));

        System.out.print("快速排序：");
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(data)));

        System.out.print("桶  排序：");
        BucketSort bucketSort = new BucketSort();
        System.out.println(Arrays.toString(bucketSort.sort(data)));

        System.out.print("计数排序：");
        CountSort countSort = new CountSort();
        System.out.println(Arrays.toString(countSort.sort(data)));

        System.out.print("基数排序：");
        RadixSort radixSort = new RadixSort();
        System.out.println(Arrays.toString(radixSort.sort(data)));

    }

}
