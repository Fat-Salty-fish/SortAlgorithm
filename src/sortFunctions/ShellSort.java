package sortFunctions;

/**
 * @Description 希尔排序简单实现 希尔排序是一种特殊的插入排序算法 设置了步长
 * @auther 李忠杰
 * @create 2019-03-11 17:00
 */
public class ShellSort {
    public static void sort(int[] array) {
        //增量step 并逐步缩小增量
        int number = array.length / 2;
        while (number >= 1) {
            for (int i = number; i < array.length; i++) {
                int j = i;
                while (j - number >= 0 && array[j] < array[j - number]) {
                    int temp = array[j];
                    array[j] = array[j - number];
                    array[j - number] = temp;
                    j = j - number;
                }
            }
            number = number / 2;
        }
    }
}
