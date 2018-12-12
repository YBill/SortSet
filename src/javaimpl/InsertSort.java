package javaimpl;

import inter.ISort;

public class InsertSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] newData = newArray(data);
        // 外层循环开始以数组第一个值作为比较点，后面一直向右移改变基准点的值
        for (int rightShift = 1; rightShift < newData.length; rightShift++) {
            int compareData = newData[rightShift]; // 用作比较的数据
            int leftShift = rightShift - 1;
            // 内层循环leftShift开始为比较点的前一个值，leftShift到最左边或比较的值compareData小于前面的数据，循环结束
            while (leftShift >= 0 && newData[leftShift] > compareData) {
                newData[leftShift + 1] = newData[leftShift];
                leftShift--;
            }
            newData[leftShift + 1] = compareData; // 最后把compareData放到前面空位上
        }
        return newData;
    }
}
