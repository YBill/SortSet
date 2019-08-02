package javaimpl;

import inter.ISort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 2018/12/19.
 * 桶排序
 */
public class BucketSort implements ISort {

    @Override
    public void sort(int[] data) {
        bucketSort(data);
    }

    private void bucketSort(int[] data) {
        // 确认桶的大小
        int length = data.length;
        int max = getMaxAndMinData(data)[0];
        int min = getMaxAndMinData(data)[1];
        int bucketNum = (max - min) / length + 1;

        // 创建bucketNum个桶
        List<List<Integer>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }

        // 将数组中的数据分别放到对应的桶中
        for (int i = 0; i < data.length; i++) {
            int bucketIndex = (data[i] - min) / length;
            buckets.get(bucketIndex).add(data[i]);
        }

        for (int i = 0; i < buckets.size(); i++) {
            insertSort(buckets.get(i), buckets.get(i).size());
        }

        // 依次将桶中的数据放回到原数组中
        for (int i = 0, k = 0; i < buckets.size(); i++) {
            List<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                data[k] = bucket.get(j);
                k++;
            }
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

    // 插入排序
    private void insertSort(List<Integer> data, int n) {
        for (int rightShift = 1; rightShift < n; rightShift++) {
            int compareData = data.get(rightShift);
            int leftShift = rightShift - 1;
            while (leftShift >= 0 && data.get(leftShift) > compareData) {
                data.set(leftShift + 1, data.get(leftShift));
                leftShift--;
            }
            data.set(leftShift + 1, compareData);
        }
    }

}
