package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/12
 */
public class LeetCode494目标和 {

    /**
     * 目标和 动态规划
     * 这个怎么动态规划呢
     * 状态：选哪些数字为+ 剩余数字为-
     * 感觉这个题有点像回溯？
     * 先用回溯尝试解决
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        traceBack(nums, new ArrayList<>(), target, 0);
        return resultList.size();
    }

    /**
     * 结果集
     */
    public List<List<Integer>> resultList = new ArrayList<>();

    /**
     * 回溯解决
     *
     * @param nums
     * @param currentPath
     * @param target
     * @param index
     */
    public void traceBack(int[] nums, List<Integer> currentPath, int target, int index) {
        // 如果已经超过了数组长度 则判断当前path是否符合要求 符合则添加到结果集合里
        if (index >= nums.length) {
            Integer sum = 0;
            for (int i = 0; i < currentPath.size(); i++) {
                sum += currentPath.get(i);
            }
            if (sum == target) {
                resultList.add(currentPath);
            }
            return;
        }
        // 如果没有超过 则当前数字作为+或者作为-传入path中
        currentPath.add(-nums[index]);
        traceBack(nums, currentPath, target, index + 1);
        currentPath.remove(currentPath.size() - 1);

        currentPath.add(nums[index]);
        traceBack(nums, currentPath, target, index + 1);
        currentPath.remove(currentPath.size() - 1);
    }


    /**
     * 回溯法可以解决这个问题
     * 但是超出了时间范围
     * 需要更好的解决办法
     * 考虑动态规划
     * 状态有哪些？
     * 若数组总和为sum 标记为负的元素和为negativeSum 则标记为正的元素和为(sum-negativeSum)
     * 则 (sum-negativeSum)-negativeSum = target
     * sum-2*negativeSum = target
     * negativeSum = (sum-target)/2
     * 即转换问题：给定数组nums 从nums里寻找一些数字 使得这些数字之和为negativeSum
     * dp[i][j] 表示在选取nums前i个数字下 目标数为j时 能符合条件的组合数量 其实不转换也可以 就是理解起来比较麻烦
     * 怎么感觉怪怪的 如何推导状态转移方程？
     * 选择 第i个是否为-
     * j就是总和了
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 看注释 问题转换
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // negative必须为非负整数 所以sum-target必须为正 并且必须为偶数
        if ((sum - target) % 2 != 0 || sum - target < 0) {
            return 0;
        }
        int negative = (sum - target) / 2;
        // 定义dp dp[i][j] 指在nums前i个数下 目标和为j的方案数量
        int[][] dp = new int[nums.length + 1][negative + 1];
        // 预处理dp i = 0时 无可选数字 方案一定为0
        // i=0并且j=0时 无可选数字 但是目标也为0 所以方案数为1
        dp[0][0] = 1;
        //  0<i<=nums.length 目标为j
        // 如果nums[i-1] > j 则不选择 方案数 dp[i][j] = dp[i-1][j]
        // 如果nums[i-1] <= j 则可以选择 方案数 dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j]
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i-1];
            for (int j = 0; j <= negative; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
//                if (nums[i - 1] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
//                }
            }
        }
        return dp[nums.length][negative];
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int result = new LeetCode494目标和().findTargetSumWays2(nums, target);
        System.out.println(result);
    }
}
