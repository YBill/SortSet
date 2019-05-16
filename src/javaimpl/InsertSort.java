package javaimpl;

import inter.ISort;

/**
 * Created by Bill on 2018/12/19.
 * 插入排序
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
public class InsertSort implements ISort {

    @Override
    public void sort(int[] data) {
        sort(data, data.length);
    }

    private void sort(int[] data, int n) {
        // 外层循环开始以数组第一个值作为比较点，后面一直向右移改变基准点的值
        for (int rightShift = 1; rightShift < n; rightShift++) {
            int compareData = data[rightShift]; // 用作比较的数据
            int leftShift = rightShift - 1;
            // 内层循环leftShift开始为比较点的前一个值，leftShift到最左边或比较的值compareData小于前面的数据，循环结束
            while (leftShift >= 0 && data[leftShift] > compareData) {
                data[leftShift + 1] = data[leftShift];
                leftShift--;
            }
            data[leftShift + 1] = compareData; // 最后把compareData放到前面空位上
        }
    }
}
