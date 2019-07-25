package javaimpl;

import inter.ISort;

import java.util.Random;

/**
 * Created by Bill on 2018/12/19.
 * 快速排序
 * <p>
 * 原地排序
 * 不稳定排序
 * <p>
 * 额外空间O(logn)
 * <p>
 * 最好O(nlogn)
 * 最坏O(n*n)
 * 平均O(nlogn)
 */
public class QuickSort implements ISort {

    private Random random;

    @Override
    public void sort(int[] data) {
        random = new Random();

        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition2(data, left, right);
        quickSort(data, left, p - 1);
        quickSort(data, p + 1, right);

    }

    /**
     * 对data[left...right]部分进行partition操作
     * <p>
     * 原理：
     *
     * @return p  返回p(p的位置已经是正确的了)，使得data[left...p-1] < data[p]; data[p+1...right] > data[p]
     */
    private int partition2(int[] data, int left, int right) {
        // 下面取第一个数为基准数，如果数组本来就是有序数组或有序度比较大时，此时排序近乎是链表，时间复杂度退化为O(n*n)
        // 为了避免这种现象每次取数组中的随机位置，然后和第一个数交换一下位置即可
        int randomPos = random.nextInt(right - left + 1) + left;
        swap(data, randomPos, left);

        int key = data[left]; // 取第一个数为基准数

        // data[left+1...i) <= key; data(left...right] >= key
        int i = left + 1, j = right;

        while (true) {
            while (i <= right && data[i] < key) i++;
            while (j >= left + 1 && data[j] > key) j--;
            if (i > j) break;

            swap(data, i, j);

            i++;
            j--;
        }

        // 交换left和j的位置，交换后data[j]的值已经是正确的位置了
        swap(data, left, j);

        return j;

    }

    private int partition(int[] data, int left, int right) {
        int key = data[left];
        int j = left;
        int i = left + 1;

        while (i <= right) {
            if (data[i] >= key) {
                i++;
            } else {
                swap(data, j + 1, i);
                j++;
                i++;
            }
        }

        swap(data, j, left);

        return j;
    }

}
