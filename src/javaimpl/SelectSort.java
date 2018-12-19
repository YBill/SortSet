package javaimpl;

import inter.ISort;

/**
 * Created by Bill on 2018/12/19.
 * 选择排序
 */
public class SelectSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] newData = newArray(data);
        for (int i = 0; i < newData.length - 1; i++) {
            int k = i;
            for (int j = k + 1; j < newData.length; j++) {
                if (newData[j] < newData[k]) {
                    k = j;
                }
            }
            if (i != k) {
                int temp = newData[i];
                newData[i] = newData[k];
                newData[k] = temp;
            }
        }
        return newData;
    }
}
