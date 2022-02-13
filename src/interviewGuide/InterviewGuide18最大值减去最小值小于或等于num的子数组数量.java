package interviewGuide;

import java.util.LinkedList;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/27
 */
public class InterviewGuide18最大值减去最小值小于或等于num的子数组数量 {

    /**
     * 最大值减去最小值小于等于num的子数组数量
     * 通过两个双端队列 来统计一段数据之内的最大值和最小值
     * 如果一个数组符合条件 那么这个数组的所有子数组都符合条件
     * 因为所有子数组的最大值和最小值都不大于/小于当前的最大值和最小值
     *
     * @param array
     * @param num
     * @return
     */
    public int subArrayNum(int[] array, int num) {
        int result = 0;
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < array.length) {
            //rightIndex一直向右 直到条件不符合
            while (rightIndex < array.length) {
                // 防止重复添加 所以判断
                if (min.isEmpty() || min.peekLast() != rightIndex) {
                    // 更新最大值
                    while (!max.isEmpty() && array[max.getLast()] < array[rightIndex]) {
                        max.pollLast();
                    }
                    max.addLast(rightIndex);
                    // 更新最小值
                    while (!min.isEmpty() && array[min.getLast()] > array[rightIndex]) {
                        min.pollLast();
                    }
                    min.addLast(rightIndex);
                }
                // 判断是否符合条件
                // 如果符合条件 则继续扩大rightIndex
                if (array[max.getFirst()] - array[min.getFirst()] <= num) {
                    rightIndex++;
                } else {
                    break;
                }
            }
            result += rightIndex - leftIndex;
            // 这里为什么可以直接用if而不是while？min和max两个队列里只保存i-j的最大值和最小值 如果最大值和最小值的下标恰好是leftIndex 则去掉即可 这是什么方法 定义法？
            while (!max.isEmpty() && max.peekFirst() <= leftIndex) {
                max.pollFirst();
            }
            while (!min.isEmpty() && min.peekFirst() <= leftIndex) {
                min.pollFirst();
            }
            leftIndex++;
        }
        return result;
    }
}
