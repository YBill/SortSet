package javaimpl;

import inter.ISort;

public class QuickSort implements ISort {

    @Override
    public int[] sort(int[] data) {
        int[] newData = newArray(data);
        quickSort(newData, 0, newData.length - 1);
        return newData;
    }

    private void quickSort(int data[], int low, int high) {
        /*
         * 原理:找一个基准数将数组分为三部分,基准数在中间，大于基准数的都在右边,小于基准数的都在左边
         * 然后再将基准数左右两边再分别以这种方式再分，后面以此类推，最终不能再分了，说明分成的每个小数组都有序了，整个数组也就有序了
         */
        if (low < high) { // low<high用来终止递归
            int left = low, right = high;
            int key = data[low]; // 选数组中第一个数为基准数
            /*
            最外层循环首先以基准数key将数组分为大于key和小于key的两部分,left=right时最外层循环结束
            */
            while (left < right) {
                /*
                当myInt[right]小于基准数时将myInt[left]换为myInt[right],并结束当前循环,否则j向前走继续查找小于基准数的myInt
                */
                while (left < right) {
                    if (data[right] < key) {
                        // 将left+1,此处left不是必须要+1的，不+1结果一样，不过每次多比较一个
                        data[left++] = data[right];
                        break;
                    } else {
                        right--;
                    }
                }

                /*
                当myInt[left]大于基准数时将myInt[right]换为myInt[left],并结束当前循环,否则left向后走继续查找大于基准数的myInt
                */
                while (left < right) {
                    if (data[left] > key) {
                        //j--同上
                        data[right--] = data[left];
                        break;
                    } else {
                        left++;
                    }
                }
            }

            data[left] = key; // 最后将基准数给myInt[left]
            quickSort(data, low, left - 1); // 递归调用排基准数左边的数组
            quickSort(data, left + 1, high); // 递归调用排基准数右边的数组
        }
    }

}
