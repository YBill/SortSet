package test;

import javaimpl.*;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        int[] data = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};

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

        System.out.print("归并排序：");
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(data)));

        System.out.print("快速排序：");
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(data)));

    }

}
