package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/7/19
 */
public class LeetCode312戳气球 {

    /**
     * 动态规划
     * 状态:数组中的第i位是否已经被选择？这么弄状态好像不太好做
     * 定义dp[i][j] 表示开区间(i,j)的气球被戳破后 得到的最大结果
     * 技巧：将nums[0]和nums[nums.length+1]设置为1 则结果即可用dp[0][nums.length]表示
     * 状态转移 假设要求dp[i][j]的值 则需要遍历i-j里所有的数作为最后一个被戳的气球
     * 假设当前最后一个被戳的气球为k  i<k<j 则dp[i][j] = dp[i][k] + dp[k][j] + nums[k] * nums[i] * nums[j]
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int[] array = new int[nums.length + 2];
        array[0] = array[array.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            array[i + 1] = nums[i];
        }
        int[][] dp = new int[array.length][array.length];
        // base case j<i时不可能有值 j=i时 值必定为0 因为dp定义的为开区间 i=j时没有气球可以戳
        // 从右下角开始遍历 倒数第二行开始遍历 倒数第一行右下角已经是0了
        for (int i = array.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < array.length; j++) {
                // 开区间 k取不到i和j
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + array[k] * array[i] * array[j]);
                }
            }
        }
        return dp[0][nums.length + 1];
    }

    public static void main(String[] args) {
        int result = new LeetCode312戳气球().maxCoins(new int[]{3,1,5,8});
        System.out.println(result);
    }
}
