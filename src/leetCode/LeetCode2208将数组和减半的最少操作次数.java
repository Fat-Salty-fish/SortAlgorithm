package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2023/7/25
 */
public class LeetCode2208将数组和减半的最少操作次数 {

    public int halveArray(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 0) {
            return 0;
        }
        double sum = 0.0;
        for (int i = 0;i<numsLength;i++){
            sum += nums[i];
        }
        double half = sum/2.0;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>((Comparator.reverseOrder()));
        for (int i : nums) {
            priorityQueue.offer((double) i);
        }
        int result = 0;
        double add = 0.0;
        while(add < half){
            double poll = priorityQueue.poll();
            priorityQueue.offer(poll/2.0);
            add+= poll/2.0;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,19,8,1};
        LeetCode2208将数组和减半的最少操作次数 test = new LeetCode2208将数组和减半的最少操作次数();
        int result = test.halveArray(nums);
        System.out.println(result);
    }
}
