package sortFunctions;

import sun.security.util.Length;

/**
 * @Description   堆排序的简单实现 堆排序的过程：构建最大/最小堆 将最大的节点和最小的节点互换即可获取最大的数
 *                互换之后调整堆的结构 重新构建为最大堆 依次获取节点 即可实现排序
 *                完全二叉树 加入有n个节点 则n-1为最后一个节点的位于数组的下标
 *                (1)假设某个节点的位置为i      则他的左子节点的位置为2i+1 右子节点的位置为2i+2(这个位置是从树的根节点为0开始计算的)
 *                                          他的左子节点的位置为2i 右子节点的位置为2i+1(这个位置是从树的根节点为1开始计算的)
 *                (2)假设某个节点的位置为i      则他的父亲节点的位置为(i-1)/2(这个位置是从树的根节点为0开始计算的)
 *                                          他的父节点的位置为i/2(这个位置是从树的根节点为1开始计算的)
 *                (3)假设某个完全二叉树中有n个节点 则n-1为最后一个节点的位于数组的下标
 *                   则 二叉树中 最后一个非叶节点的节点为 (n-1-1)/2 = (n/2)-1 即位于数组中的下标
 * @auther 李忠杰
 * @create 2019-03-25 14:53
 */
public class HeapSort {
    //主要排序的过程 接受一个要排序的数组
    public static void sort(int[] array){
        //每构建一次最大堆 就可以取出一个最大的数
        for(int i = 0;i<array.length;i++){
            makeMaxHeap(array, array.length-i);

            int temp = array[0];
            array[0] = array[(array.length-1) - i];
            array[(array.length-1) - i] = temp;
        }
    }


    //构建最大堆 调整堆为最大堆
    //array 表示要排序的数组 i表示正在进行处理的节点 length表示现在要处理的数组的长度
    public static void adjustHeap(int[] array, int current, int length) {
        if(current<length) {
            int left = current * 2 + 1;           //左子树的下标
            int right = current * 2 + 2;          //又子树的下标

            int max = current;

            //如果左子树在范围之内
            if (left < length) {
                if (array[max] < array[left])
                    max = left;
            }
            //如果右子树在范围之内
            if (right < length) {
                if (array[max] < array[right])
                    max = right;
            }
            //如果此时的最大值不是current的值
            if (max != current) {
                int temp = array[max];
                array[max] = array[current];
                array[current] = temp;
                adjustHeap(array,max,length);
            }
        }
    }

    //用来构建最大堆的函数
    public static void makeMaxHeap(int[] array,int length){
        //从最后一个非叶子结点开始 对每一个子树进行构建最大堆 从下往上构建
        for(int i = length-1;i>=0;i--){
            adjustHeap(array,i,length);
        }
    }
}
