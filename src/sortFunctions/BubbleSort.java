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
}
