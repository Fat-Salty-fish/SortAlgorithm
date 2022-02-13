package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/5
 */
public class LeetCode239滑动窗口最大值 {

    /**
     * 感觉是动态规划
     * dp会超时....操
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[][] dp = new int[nums.length + 1][k + 1];
        dp[1][0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            dp[i][1] = nums[i - 1];
        }

        // 处理DP
        for (int i = 2; i <= nums.length; i++) {
            for (int j = 2; j <= Math.min(i, k); j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], nums[i - 1]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = k; i <= nums.length; i++) {
            result.add(dp[i][k]);
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    /**
     * 最大堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        int numsSize = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numsSize; i++) {
            int num = nums[i];
            pq.offer(new int[]{num, i});
            while (pq.peek()[1] < i - k + 1) {
                pq.poll();
            }
            result.add(pq.peek()[0]);
        }
        // 个数有多少个？如果k为1 则size = nums.length 如果k为2 则size = nums.length -1
        int[] resultArray = new int[result.size() - k + 1];
        for (int i = k - 1; i < result.size(); i++) {
            resultArray[i - k + 1] = result.get(i);
        }
        return resultArray;
    }

    /**
     * 使用双端队列实现
     * 实际上就是栈 队列是单调递增的
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[i] > nums[list.getLast()]) {
                list.removeLast();
            }
            list.add(i);
            while (list.getFirst() <= i - k) {
                list.removeFirst();
            }
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.getFirst()];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1, -1};
        int[] result = new LeetCode239滑动窗口最大值().maxSlidingWindow3(array, 1);
        System.out.println(result);
    }
}
