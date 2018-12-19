package javaimpl;

import inter.ISort;

/**
 * Created by Bill on 2018/12/19.
 * 基数排序
 */
public class RadixSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] newData = newArray(data);
        radixSort(newData);
        return newData;
    }

    private void radixSort(int[] data) {
        int length = data.length;
        int max = getMaxCount(data);

        for (int digit = 1; max / digit > 0; digit *= 10) {
            int[] tempArr = new int[length];
            int[] buckets = new int[10];

            for (int i = 0; i < length; i++)
                buckets[getDigitCount(data[i], digit)]++;

            for (int i = 1; i < 10; i++)
                buckets[i] += buckets[i - 1];

            for (int i = length - 1; i >= 0; i--) {
                int value = getDigitCount(data[i], digit);
                tempArr[buckets[value] - 1] = data[i];
                buckets[value]--;
            }

            for (int i = 0; i < length; i++)
                data[i] = tempArr[i];

        }
    }

    /**
     * 获取某个正整数value对应位数digit的值
     *
     * @param value
     * @param digit 位数 1(个位数),10(十位数),100(百位数)...
     * @return
     */
    private int getDigitCount(int value, int digit) {
        return (value / digit) % 10;
    }

    private int getMaxCount(int[] data) {
        return findMax(data, 0, data.length - 1);
    }

    /**
     * 递归获取最大值
     */
    private int findMax(int[] data, int left, int right) {
        if (left == right) {
            return data[left];
        } else {
            int a = data[left];
            int b = findMax(data, left + 1, right);
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    }

}
