package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/17
 */
public class LeetCode1230抛掷硬币 {

    /**
     * 动态规划特训
     * dp[i][j]
     * @param prob
     * @param target
     * @return
     */
    public double probabilityOfHeads(double[] prob, int target) {
        double[][] dp = new double[prob.length + 1][target + 1];
        dp[0][0] = 1.0;
        // j == 0时 没有任何一个硬币需要抛正面 所以都抛反面
        for (int i = 1; i <= prob.length; i++) {
            dp[i][0] = (1.0 - prob[i - 1]) * dp[i - 1][0];
        }
        // i == 0 时 没有硬币可以抛 不需要处理
        // i == 1 时 只有一个硬币可以抛
        for (int i = 1; i <= prob.length; i++) {
            for (int j = 1; j <= Math.min(i, target); j++) {
                // 抛一枚硬币 要么朝上 要么朝下
                // dp[i][j]=第i个硬币朝上+第i个硬币朝下的概率之和
                // 只和dp的上一行有关 可以优化dp数组大小
                dp[i][j] = dp[i - 1][j - 1] * prob[i-1] + dp[i - 1][j] * (1.0 - prob[i-1]);
            }
        }
        return dp[prob.length][target];
    }


    public static void main(String[] args) {
        double[] prob = new double[]{0.4};
        double result = new LeetCode1230抛掷硬币().probabilityOfHeads(prob,1);
    }
}
