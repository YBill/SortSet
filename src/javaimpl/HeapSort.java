package javaimpl;

import inter.ISort;

/**
 * Created by Bill on 2019/5/6.
 * 堆排序
 * <p>
 * 原地排序
 * 不稳定排序
 * <p>
 * 额外空间O(1)
 * <p>
 * 最好O(nlogn)
 * 最坏O(nlogn)
 * 平均O(nlogn)
 */
public class HeapSort implements ISort {

    @Override
    public void sort(int[] data) {
        heapSort(data, data.length);
    }

    private void heapSort(int[] arr, int n) {
        // heapify(构建堆)
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        // sort
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            shiftDown(arr, i, 0);
        }
    }

    private void shiftDown(int[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j += 1;
            }

            if (arr[k] >= arr[j]) {
                break;
            }

            int temp = arr[k];
            arr[k] = arr[j];
            arr[j] = temp;

            k = j;

        }
    }

}
