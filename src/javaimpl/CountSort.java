package javaimpl;

import inter.ISort;

/**
 * Created by Bill on 2018/12/19.
 * 计数排序
 */
public class CountSort implements ISort {

    @Override
    public void sort(int[] data) {
        countSort(data);
    }

    private void countSort(int[] data) {
        // 确定桶大小
        int length = data.length;
        int max = getMaxAndMinData(data)[0];
        int min = getMaxAndMinData(data)[1];
        int[] buckets = new int[max - min + 1];

        // 每个桶中放的不是数组中的数，而是数组中数的个数
        for (int i = 0; i < length; i++) {
            buckets[data[i] - min]++;
        }

        // 对buckets数组顺序求和，则buckets的含义为：buckets[i]里存的是小于等于i的数的个数
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }

        int[] tempArr = new int[length];

        // 倒序遍历，下面注释的正序遍历，正序遍历就变成不稳定排序了
        // 根据buckets中每个数的含义可以确定所在的下标，取出一个少一个，对应下标-1
        for (int i = length - 1; i >= 0; i--) {
            int value = data[i] - min;
            tempArr[buckets[value] - 1] = data[i];
            buckets[value]--;
        }

        // 正序遍历
        /*for(int i = 0; i < length; i++) {
            int value = data[i] - min;
            tempArr[buckets[value] - 1] = data[i];
            buckets[value]--;
        }*/

        for (int i = 0; i < length; i++) {
            data[i] = tempArr[i];
        }

    }

    /**
     * 获取最大值和最小值
     *
     * @param data
     * @return [最大值][最小值]
     */
    private int[] getMaxAndMinData(int[] data) {
        int length = data.length;
        int[] arr = new int[]{
                data[0], data[0]
        };
        for (int i = 1; i < length; i++) {
            if (data[i] > arr[0])
                arr[0] = data[i];
            if (data[i] < arr[1])
                arr[1] = data[i];
        }

        return arr;
    }

}
