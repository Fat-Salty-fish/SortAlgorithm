package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/27
 */
public class LeetCode486预测赢家 {


    /**
     * 预测赢家
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        int arrayLength = nums.length;
        // 当前选手在i-j范围内选择时的最大值
        int[][] dp = new int[arrayLength][arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = arrayLength - 2; i >= 0; i--) {
            for (int j = i + 1; j < arrayLength; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][arrayLength - 1] >= 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2};
        boolean result = new LeetCode486预测赢家().PredictTheWinner(array);
        System.out.println(result);
    }
}
