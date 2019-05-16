package inter;

public interface ISort {

    /**
     * 对数组排序
     *
     * @param data 原始数据
     */
    void sort(int[] data);

    /**
     * 交换下标为i和j在数组的数据
     *
     * @param data
     * @param i
     * @param j
     */
    default void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
