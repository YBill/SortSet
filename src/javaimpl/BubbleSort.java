package javaimpl;

import inter.ISort;

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
