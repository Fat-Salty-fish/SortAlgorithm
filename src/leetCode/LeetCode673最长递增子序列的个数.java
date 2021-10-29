package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/20
 */
public class LeetCode673最长递增子序列的个数 {

    /**
     * 动态规划特训
     * 最长递增子序列的个数
     * 与最长递增子序列类似吧应该
     * 看完答案之后：和最长递增子序列是有关的
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        // 定义dp 记录最长递增子序列长度
        int[] dp = new int[nums.length];
        // 定义cnt 记录最长递增子序列个数 表示在第i位之前的数组的最长递增子序列的个数
        int[] cnt = new int[nums.length];
        // 用来记录最长的递增子序列的长度
        int maxLength = 0;
        // 用来记录最长递增子序列长度时的序列个数
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                // 此时需要在nums[j]后再添加一个数字来组成当前情况下的最长子序列
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        // 此时如果dp[j]+1情况更新了 说明最长递增子序列的长度更新了 同时最长递增子序列的数量也需要更新了
                        // cnt[i]如何更新？ 因为位置是在j时发生了变换 所以此时cnt[i] = cnt[j]
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        // dp[j] + 1 长度和dp[i]相同时 dp[i]不变 找到了新的相同长度的方案 cnt[i] += cnt[j]
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxCount = cnt[i];
            } else if (dp[i] == maxLength) {
                maxCount += cnt[i];
            }
        }
        return maxCount;
    }
}
