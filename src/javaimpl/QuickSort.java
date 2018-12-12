package javaimpl;

import inter.ISort;

public class QuickSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] newData = newArray(data);
        quickSort(newData, 0, newData.length - 1);
        return newData;
    }

    private void quickSort(int data[], int l, int r) {
         /*
         原理:找一个基准数将数组分为两部分,大于基准数的都在右边,小于基准数的都在左边,然后将分成的两部分再分别以基准数的方式分成两部分，后面以此类推
         */
        if (l < r) { // l<r用来终止递归
            int i = l, j = r;
            int key = data[l]; // 选数组中第一个数为基准数
            /*
            最外层循环首先以基准数key将数组分为大于key和小于key的两部分,i=j时最外层循环结束
            */
            while (i < j) {
                /*
                当myInt[j]小于基准数时将myInt[i]换为myInt[j],并结束当前循环,否则j向前走继续查找小于基准数的myInt
                */
                while (i < j) {
                    if (data[j] < key) {
                        // 将i+1,此处i不是必须要+1的，不+1结果一样，不过每次多比较一个
                        data[i++] = data[j];
                        break;
                    } else {
                        j--;
                    }
                }

                /*
                当myInt[i]大于基准数时将myInt[j]换为myInt[i],并结束当前循环,否则i向后走继续查找大于基准数的myInt
                */
                while (i < j) {
                    if (data[i] > key) {
                        //j--同上
                        data[j--] = data[i];
                        break;
                    } else {
                        i++;
                    }
                }
            }

            data[i] = key; // 最后将基准数给myInt[i]
            quickSort(data, l, i - 1); // 递归调用排基准数左边的数组
            quickSort(data, i + 1, r); // 递归调用排基准数右边的数组
        }
    }

}
