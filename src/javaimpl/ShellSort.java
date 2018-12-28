package javaimpl;

import inter.ISort;

/**
 * Created by Bill on 2018/12/28.
 * 希尔排序
 */
public class ShellSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] newData = newArray(data);
        int length = newData.length;
        for (int step = length / 2; step > 0; step /= 2) {
            for (int rightShift = step; rightShift < length; rightShift++) {
                int compareData = newData[rightShift];
                int leftShift = rightShift;
                while (leftShift - step >= 0 && newData[leftShift - step] > compareData) {
                    newData[leftShift] = newData[leftShift - step];
                    leftShift = leftShift - step;
                }
                newData[leftShift] = compareData;
            }
        }
        return newData;
    }

}
