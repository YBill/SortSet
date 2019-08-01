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
 * 最好O(n)(本来就是有序的时候，需要加个条件在第一次内循环结束直接中断外循环)
 * 最坏O(n*n)
 * 平均O(n*n)
 */
public class BubbleSort implements ISort {

    @Override
    public void sort(int[] data) {
        sort(data, data.length);
    }

    private void sort(int[] data, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

}
