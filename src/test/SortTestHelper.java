package test;

import java.util.Arrays;
import java.util.Random;

public enum SortTestHelper {

    INSTANCE;

    private Random random = new Random(37);

    public void checkSortOrder(String sortName, int[] arr, int n) {
        if (isSorted(arr, n)) {
            return;
        }

        System.out.println(sortName + " 排序不正确");
    }

    private boolean isSorted(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算排序耗时
     *
     * @param sortName          排序名称
     * @param sortTestInterface 排序
     */
    public void testSort(String sortName, SortTestInterface sortTestInterface) {
        long startTime = System.currentTimeMillis();
        int[] arr = sortTestInterface.sort();
        long time = System.currentTimeMillis() - startTime;
        System.out.println(sortName + "：" + (time / 1000.0));

        // 验证排序是否正确
        checkSortOrder(sortName, arr, arr.length);
    }

    /**
     * 生成随机数组
     *
     * @param n      数组大小
     * @param rangeL 数组中最小数
     * @param rangeR 数组中最大数
     * @return
     */
    public int[] generateRandomArray(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    /**
     * 复制一个新数组
     *
     * @param data
     * @param n
     * @return
     */
    public int[] copyArray(int[] data, int n) {
        return Arrays.copyOf(data, n);
    }

}
