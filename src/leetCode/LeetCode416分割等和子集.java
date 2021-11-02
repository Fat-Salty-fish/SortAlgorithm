package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/12
 */
public class LeetCode416分割等和子集 {

    /**
     * 分割子集
     * 动态规划
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        // 不为偶数 一定无法平均划分 返回false
        if (sum % 2 != 0) {
            return false;
        }
        // 总和为一半的值
        int half = sum / 2;
        // 如果最大的数大于half 那就算把除了最大数以外的数全部加起来也无法达到half 返回失败
        if (max > half) {
            return false;
        }
        // 两个状态：1.当前数组的位置i 2.数组之和j
        // 定义数组dp[i][j] 表示在前i个元素之下 能否加出来总和为j
        // 结果:dp[nums.length-1][half]
        //
        boolean dp[][] = new boolean[nums.length][half + 1];
        // 预处理这个二维数组 j为0的时候 dp[i][0]总为true
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        // i为0的时候 dp[0][j]取决于nums[0]是否等于j 这里不需要遍历 因为只能取到第一个数字
        // 这里是否需要担心越界问题？应该不需要 前面max>half已经过滤掉了
        dp[0][nums[0]] = true;
        // dp处理
        // 选择 nums[i]是否选择这个数字
        // 如果nums[i] 大于j 则必定不选择这个数字 因为如果选择了这个数字会超过j 此时 dp[i][j] = dp[i-1][j]
        // 否则 可以选择nums[i] dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]]
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < half + 1; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][half];
    }

    /**
     * 分割等和子集二刷
     * 压缩动态规划数组
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        // 不为偶数 一定无法平均划分 返回false
        if (sum % 2 != 0) {
            return false;
        }
        // 总和为一半的值
        int half = sum / 2;
        // 如果最大的数大于half 那就算把除了最大数以外的数全部加起来也无法达到half 返回失败
        if (max > half) {
            return false;
        }
        // 定义动态规划数组并且压缩 从一刷来看 dp[i][j]只和dp[i-1][j..]有关 所以可以压缩到一维的dp数组
        // 并且要从大到小遍历 如果从小到大遍历会导致dp[j]已经不是上一行的数字了
        boolean[] dp = new boolean[half + 1];
        // 初始化 j = 0时为true
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = half; j >= num; j--) {
                dp[j] = dp[j - num] || dp[j];
            }
        }
        return dp[half];
    }


    /**
     * 二刷动态规划 分割等和子集3
     * 即 能否选出一些数字 使得这些数字之和等于元数组之和的一半
     *
     * @param nums
     * @return
     */
    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 元素之和不为偶数 无法均分 肯定得不到结果
        if (sum % 2 != 0) {
            return false;
        }
        // 数组和的一半
        int half = sum / 2;
        // dp[i][j]表示 数组前i个数之内 总和为j 能否拼出来
        boolean[][] dp = new boolean[nums.length + 1][half + 1];
        // base case i=0时 没有数可以选 自然都为false
        // j=0时 不需要任何数 都为true
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= half; j++) {
                int num = nums[i - 1];
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - num] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][half];
    }

    /**
     * 4刷
     * 动态规划
     * 元素和相同 就是能否取得一系列数能够达到所有数的一半
     *
     * @param nums
     * @return
     */
    public boolean canPartition4(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int each : nums) {
            sum += each;
        }
        if (sum % 2 != 0) {
            return false;
        }
        // 总数的一半
        int half = sum / 2;
        int numLength = nums.length;
        boolean[][] dp = new boolean[numLength + 1][half + 1];
        // base case j==0时 i不论为多少 结果均为true
        for (int i = 0; i <= numLength; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= numLength; i++) {
            for (int j = 1; j <= half; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[numLength][half];
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1};
        boolean result = new LeetCode416分割等和子集().canPartition4(nums);
        System.out.printf("结果" + result);
    }
}
