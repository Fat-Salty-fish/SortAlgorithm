package sortFunctions;

/**
 * @Description 快速排序实现
 * @auther 李忠杰
 * @create 2019-02-27 11:19
 */
public class QuickSort {
    //快速排序实现 传入参数为数组，起始位置以及结束位置
    public static void sort(int[] array, int start, int end) {
        if (start >= end || array == null || array.length <= 1) {
            return;
        }
        int standard = array[(end + start) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (array[i] < standard) {
                i++;
            }
            while (array[j] > standard) {
                j--;
            }
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                i++;
                j--;
            } else if (i == j) {
                ++i;
            }
        }
        sort(array, start, j);
        sort(array, i, end);
    }

    public static void sort2(int[] array, int start, int end) {
        if (start >= end || array == null || array.length <= 1) {
            return;
        }
        int i = start;
        int j = end;
        int standard = array[start];
        while (i < j) {
            while (i < j && array[j] >= standard) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= standard) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = standard;
        sort2(array, start, i);
        sort2(array, i + 1, end);
    }
}
