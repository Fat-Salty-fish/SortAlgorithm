package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/18
 */
public class LeetCode552学生出勤记录II {

    /**
     * 返回能够领取奖励的方案次数
     * 从题目上来看 这个题可以用回溯法来解决
     * 但是看了一下数量级 n最大为10的5次方 回溯法一定会超时
     * 应该是要用动态规划解决
     * 动态规划解决问题的思路 ：
     * 状态和选择
     * 要求： 总出勤次数中 旷到的次数小于2
     * 连续迟到的次数 小于3
     * 所以状态 总出勤天数 i 旷到次数 j 结尾连续迟到次数 k
     *
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // i 有i天的出勤记录 j 旷到次数 k 结尾连续迟到次数 其中  0<=i<=n  0<=j<2 0<=k<3
        int dp[][][] = new int[n + 1][2][3];
        // 初始化 dp[0][0][0]=1 i==0时 j与k一定为0 所以dp[0][0][0] = 1
        dp[0][0][0] = 1;
        // 动态规划
        // dp[i] 与dp[i-1]如何建立关系 取决于今天的出勤情况
        // 如果今天准时 则dp[i][j][k] = dp[i-1][j][k] dp[i-1][j][0] + dp[i-1][j][1] + dp[i-1][j][2]
        // 如果今天旷到 则dp[i][j][k] = dp[i-1][j-1][k]
        // 如果今天迟到 则dp[i][j][k] = dp[i-1][j][k-1]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {

                }
            }
        }
        return 0;
    }
}
