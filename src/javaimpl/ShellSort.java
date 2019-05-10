package javaimpl;

import inter.ISort;

/**
 * Created by Bill on 2018/12/28.
 * 希尔排序(插入排序的改进版)
 * <p>
 * 原地排序
 * 不稳定排序
 * <p>
 * 额外空间O(1)
 * <p>
 * 最好O(n)
 * 最坏O(n*n)
 * 平均O(n^1.3)（n的1.3次方）
 */
public class ShellSort implements ISort {

    @Override
    public void sort(int[] data) {
        int length = data.length;
        for (int step = length / 2; step > 0; step /= 2) {
            for (int rightShift = step; rightShift < length; rightShift++) {
                int compareData = data[rightShift];
                int leftShift = rightShift;
                while (leftShift - step >= 0 && data[leftShift - step] > compareData) {
                    data[leftShift] = data[leftShift - step];
                    leftShift = leftShift - step;
                }
                data[leftShift] = compareData;
            }
        }
    }

}
