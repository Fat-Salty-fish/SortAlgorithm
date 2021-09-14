package leetCode;

/**
 * @author lizhongjie
 * @desc 动态规划训练 最长递增子序列
 * @create_time 2021/8/21
 */
public class LeetCode300最长递增子序列 {

    /**
     * 最长递增子序列 如何运算？
     * 问题拆解
     * 状态定义
     * 递归方程推导
     * 实现
     * <p>
     * 第一步 问题拆解 在计算最长递增子序列时 需要知道前面的递增子序列长度 递增子序列里最后一个数字是多少
     * 第二步 状态定义 由问题拆解看 需要两个状态 一是数组位置 二是是否选择当前数字
     * 第三步
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        // 没有其他办法 只能每一次都遍历一次数组
        int[] dp = new int[nums.length];
        // 初始化 也就是base case
        dp[0] = 1;
        int currentMax = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] +1);
                }
            }
            currentMax = Math.max(currentMax,dp[i]);
        }

        return currentMax;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = new LeetCode300最长递增子序列().lengthOfLIS(nums);
        System.out.println(length);
    }
}
