package sortFunctions;

/**
 * @Description 基数排序实现 此排序算法排序的数字必须为正整数
 *              将正整数按照位进行排序 一般使用LSD(低位优先)算法 也可以使用MSD(高位优先)算法 将数字存入桶中
 *              高位补0 先对低位进行排序 然后依次对高位进行排序
 * @auther 李忠杰
 * @create 2019-03-26 16:50
 */
public class RadixSort {
    //对数组内的数据进行基数排序
    public static void sort(int[] array){
        //初始化10个桶 用来存放排序过程中的数据
        int[][] bucket = new int[10][array.length];
        //初始化一个和传入的数组长度相同的数组 以免在排序过程中的多次地址开辟
        int[] temp = new int[array.length];

    }
}
