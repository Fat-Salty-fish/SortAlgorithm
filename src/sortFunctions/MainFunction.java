package sortFunctions;

import java.util.Arrays;

/**
 * @Description
 * @auther 李忠杰
 * @create 2019-02-26 11:49
 */
public class MainFunction {
    public static void main(String[] args) {
        int[] array = {5,1,8,4,2,6,7,1,2,1,4,7,8,10,55};
        System.out.println(Arrays.toString(array));
//        BubbleSort.sort(array);
//        QuickSort.sort(array,0,array.length-1);
//        QuickSort.sort2(array,0,array.length-1);
//        InsertSort.sort(array);
//        ShellSort.sort(array);
//        SelectSort.sort(array);
//        MyMergeSort.sort(array);
//        RadixSort.sort(array);
//        HeapSort.sort(array);
        int[] res = HeapSort.heapSort(array);
        Arrays.stream(res).forEach(i->System.out.print(i+" "));
    }
}
