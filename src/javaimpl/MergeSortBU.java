package javaimpl;

import inter.ISort;

/**
 * 自底向上的归并排序
 * <p>
 * 同{@link MergeSort} 不用递归直接遍历
 * 因为数组没使用过索引，故可以以nlogn对链表进行排序
 */
public class MergeSortBU implements ISort {
    @Override
    public void sort(int[] data) {
        sort(data, data.length);
    }

    private void sort(int[] data, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对data[i...i + sz - 1]和data[i + sz...i + 2*sz - 1]两部分进行归并
                merge(data, i, i + sz - 1, min(i + sz + sz - 1, n - 1));
            }
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

    private int min(int a, int b) {
        return (a <= b) ? a : b;
    }

}
