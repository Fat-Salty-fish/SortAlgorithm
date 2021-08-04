package sortFunctions;

/**
 * @Description 冒泡排序实现
 * @auther 李忠杰
 * @create 2019-02-26 11:43
 */
public class BubbleSort {
    //冒泡排序 每次将大的数往后放
    public static void sort(int[] array){
        //对于数组内的每一个数
        for(int i = 0;i<array.length;i++){
            //对剩余的数字进行排序
            for(int j = 0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int var = array[j+1];
                    array[j+1] = array[j];
                    array[j] = var;
                }
            }
        }
    }

    /**
     * 冒泡排序第一次优化 如果在某一次排序之后已经排序完成 则无需后续再比较 减少循环次数
     * 用一个标记位来判断当前排序是否已经完成
     * @param array
     */
    public static void bubbleSortOptimizeFirst(int[] array){
        int single = 0;
        int temp;
        // array.length个数 大循环只要length-1次 最后一个数已经不需要排序了
        for (int i = 0; i < array.length - 1; i++) {
            // 每次循环 最多只判断length-1-i个数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    single = 1;
                }
            }
            if (single == 0){
                break;
            }
        }
    }

    /**
     * 冒泡排序 二次优化 上一次优化减少了要排序的大循环
     * 这次优化减少小循环循环次数
     * 使用一个标记位置 下次循环到此标记位置即截止
     * @param array
     */
    public static void bubbleSortOptimizeSecond(int[] array) {
        int single = 0;
        int temp;
        int length = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            int tempLength = -1;
            for (int j = 0; j < length; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    // j为交换后的最后一个位置
                    tempLength = j;
                    single = 1;
                }
            }
            if (single == 0) {
                break;
            }
            if (tempLength != -1) {
                length = tempLength;
            }
        }
    }
}
