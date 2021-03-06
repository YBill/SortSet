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
    public void sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    // 递归使用归并排序，对data[l...r]的范围进行排序
    private void mergeSort(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2; // int mid = (low + high) / 2 存在数值太大溢出问题

        // 左边
        mergeSort(data, low, mid);

        // 右边
        mergeSort(data, mid + 1, high);

        // 左右归并
//        if (data[mid] > data[mid + 1]) // 这个判断可以对几乎有序的数据进行优化
        merge(data, low, mid, high);
    }

    // 将data[low...mid]和data[mid+1...high]两部分进行归并
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
