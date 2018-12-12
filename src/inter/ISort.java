package inter;

import java.util.Arrays;

public interface ISort {

    /**
     * 对数组排序
     *
     * @param data 原始数据
     * @return 返回排序后的数组
     */
    int[] sort(int[] data);

    /**
     * 创建一个新的数组
     *
     * @param data 原始数据
     * @return
     */
    default int[] newArray(int[] data) {
        return Arrays.copyOf(data, data.length);
    }
}
