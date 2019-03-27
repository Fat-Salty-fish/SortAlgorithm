package sortFunctions;

/**
 * @Description 基数排序实现 此排序算法排序的数字必须为正整数 即不能小于等于0
 * 将正整数按照位进行排序 一般使用LSD(低位优先)算法 也可以使用MSD(高位优先)算法 将数字存入桶中
 * 高位补0 先对低位进行排序 然后依次对高位进行排序
 * @auther 李忠杰
 * @create 2019-03-26 16:50
 */
public class RadixSort {
    //对数组内的数据进行基数排序
    public static void sort(int[] array) {
        //初始化10个桶 用来存放排序过程中的数据
        int[][] bucket = new int[10][array.length];
        //初始化一个和传入的数组长度相同的数组 以免在排序过程中的多次地址开辟
        //用于存放某个桶中有多少个数字 最多存放array.length个数量的数字
        int[] temp = new int[array.length];
        //获取数组中的最大位数
        int bit = bitNum(array);
        //对于每一位的数字进行排序 即LSD(低位优先)
        int max = (int) Math.pow(10, bit);
        //表示第几位
        int n = 1;
        while (n <= max) {
            //将数组中的数字存入桶中
            for (int i = 0; i < array.length; i++) {
                int redundant = (array[i]/n)%10;
                bucket[redundant][temp[redundant]] = array[i];
                temp[redundant]++;
            }
            //将上述桶中的数据再取出来 覆盖掉之前的数据
            //对于每一个桶
            int index = 0;
            for (int i = 0; i < 10; i++) {
                //对于每一个桶内的每一个数字
                //当桶内的数字大于0的时候才取数字
                if (temp[i] != 0) {
                    for (int j = 0; j < temp[i]; j++) {
                        array[index] = bucket[i][j];
                        index++;
                    }
                }
                temp[i] = 0;
            }
            n = n * 10;
        }
    }

    //计算数组中位数最大的数字
    private static int bitNum(int[] array) {
        int bit = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > temp) {
                temp = array[i];
            }
        }
        return String.valueOf(temp).toCharArray().length;
    }
}
