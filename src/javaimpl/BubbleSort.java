package javaimpl;

import inter.ISort;

/**
 * Created by Bill on 2018/12/19.
 * 冒泡排序
 * <p>
 * 原地排序
 * 稳定排序
 * <p>
 * 额外空间O(1)
 * <p>
 * 最好O(n)
 * 最坏O(n*n)
 * 平均O(n*n)
 */
public class BubbleSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] newData = newArray(data);
        for (int i = 1; i < newData.length; i++) {
            for (int j = 0; j < newData.length - i; j++) {
                if (newData[j] > newData[j + 1]) {
                    int temp = newData[j];
                    newData[j] = newData[j + 1];
                    newData[j + 1] = temp;
                }
            }
        }
        return newData;
    }
}
