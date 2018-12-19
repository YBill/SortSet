package javaimpl;

import inter.ISort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bill on 2018/12/19.
 * 桶排序
 */
public class BucketSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] newData = newArray(data);
        bucketSort(newData);
        return newData;
    }

    private void bucketSort(int[] data) {
        int length = data.length;
        int max = getMaxAndMinData(data)[0];
        int min = getMaxAndMinData(data)[1];
        int bucketNum = (max - min) / length + 1;

        List<List<Integer>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            int bucketIndex = (data[i] - min) / length;
            buckets.get(bucketIndex).add(data[i]);
        }

        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }

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

}
