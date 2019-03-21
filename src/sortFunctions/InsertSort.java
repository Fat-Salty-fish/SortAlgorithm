package sortFunctions;

/**
 * @Description 插入排序实现
 * @auther 李忠杰
 * @create 2019-03-01 16:06
 */
public class InsertSort {
    //插入简单实现 对于每一个元素 认为它的前面所有元素已经有序了 将这个数字插入到前面的序列中即可
    //找到适合这元素的位置
    public static void sort(int[] array) {
        //默认第一个元素已经排好序了
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
