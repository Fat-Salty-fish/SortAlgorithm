package sortFunctions;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-03-25 8:43
 */
public class SelectSort {
    public static void sort(int[] array){
        for(int i = 0;i<array.length;i++){  //对于数组中的每一个元素进行操作 或者来说 对于数组中的每一个位置进行操作
            int min = i;
            for(int j = i+1;j<array.length;j++){      //查找未排序数组中的最小值的下标
                if(array[j]<array[min]){                //找到未排序数组中的最小值的位置 存入临时变量max中
                    min = j;
                }
            }
            if(min!=i){                                 //将最小值存入array[i]中去
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }
}
