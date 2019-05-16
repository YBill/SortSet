package javaimpl;

import inter.ISort;

import java.util.Random;

/**
 * 三路快速排序
 * 将数据分为等于key，大于key和小于key三部分。每次分完等于key的部分就不用处理了。
 * 当数据中有大部分重复元素时比较快
 */
public class QuickSort3Ways implements ISort {

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

        // partition

        int randomPos = random.nextInt(right - left + 1) + left;
        swap(data, randomPos, left);

        int key = data[left];

        int lt = left; // data[l+1...lt] < key
        int gt = right + 1; // data[gt...r] > key
        int i = left + 1; // data[lt+1...i) == key

        while (i < gt) {
            if (data[i] < key) {
                swap(data, i, lt + 1);

                lt++;
                i++;
            } else if (data[i] > key) {
                swap(data, i, gt - 1);
                gt--;
            } else { // data[i]==key
                i++;
            }
        }

        swap(data, left, lt);
        lt--;

        quickSort(data, left, lt);
        quickSort(data, gt, right);

    }

}
