package javaimpl;

import inter.ISort;

/**
 * Created by Bill on 2018/12/19.
 * 归并排序
 * <p>
 * 非原地排序
 * 稳定排序
 * <p>
 * 额外空间O(n)
 * <p>
 * 最好O(nlogn)
 * 最坏O(nlogn)
 * 平均O(nlogn)
 */
public class MergeSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] newData = newArray(data);
        mergeSort(newData, 0, newData.length - 1);
        return newData;
    }

    private void mergeSort(int[] data, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(data, low, mid);
            // 右边
            mergeSort(data, mid + 1, high);
            // 左右归并
            merge(data, low, mid, high);
        }
    }

    private void merge(int[] data, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;// 左指针
        int right = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (left <= mid && right <= high) {
            if (data[left] <= data[right]) { // <= 的话原始位置不变即稳定排序
                temp[k++] = data[left++];
            } else {
                temp[k++] = data[right++];
            }
        }
        // 把左边剩余的数移入数组
        while (left <= mid) {
            temp[k++] = data[left++];
        }
        // 把右边边剩余的数移入数组
        while (right <= high) {
            temp[k++] = data[right++];
        }
        // 把新数组中的数覆盖data数组
        for (int i = 0; i < temp.length; i++) {
            data[i + low] = temp[i];
        }
    }

}
