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

    /**
     * 动态规划 二刷
     * 假设[L,R]整个区间是最后被戳破的气球 并且L-1 R+1并没有被打爆
     * 则如果L是最后一个被打爆的 result = nums[L-1] * nums[L] * nums[R+1] + dp[L+1][R];
     * 所以 遍历所有的L 和 R 并且在L和R之间确定最后一个
     * L不可能超过R L的取值范围为 1-1+nums.length R的取值范围是L-1+nums.length
     *
     * @param nums
     * @return
     */
    public int maxCoins2(int[] nums) {
        int[] numsWithBarriers = new int[nums.length + 2];
        numsWithBarriers[0] = 1;
        numsWithBarriers[nums.length + 1] = 1;
        System.arraycopy(nums, 0, numsWithBarriers, 1, nums.length);
        int[][] dp = new int[numsWithBarriers.length][numsWithBarriers.length];
        for (int left = numsWithBarriers.length - 2; left >= 0; left--) {
            for (int right = left + 1; right < numsWithBarriers.length; right++) {
                for (int temp = left + 1; temp < right; temp++) {
                    dp[left][right] = Math.max(dp[left][right], numsWithBarriers[left] * numsWithBarriers[right] * numsWithBarriers[temp] + dp[left][temp] + dp[temp][right]);
                }
            }
        }
        return dp[0][nums.length + 1];
    }

    /**
     * 三刷 修改动态规划数组定义
     *
     * @param nums
     * @return
     */
    public int maxCoins3(int[] nums) {
        int[] numsWithBarriers = new int[nums.length + 2];
        numsWithBarriers[0] = numsWithBarriers[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            numsWithBarriers[i + 1] = nums[i];
        }
        int[][] dp = new int[numsWithBarriers.length][numsWithBarriers.length];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][i] = nums[i - 1];
        }
        for (int left = numsWithBarriers.length - 2; left > 0; left--) {
            for (int right = left; right <= numsWithBarriers.length - 2; right++) {
                for (int temp = left; temp <= right; temp++) {
                    dp[left][right] = Math.max(dp[left][right], numsWithBarriers[temp] * numsWithBarriers[left - 1] * numsWithBarriers[right + 1] + dp[left][temp - 1] + dp[temp + 1][right]);
                }
            }
        }
        return dp[1][numsWithBarriers.length - 2];
    }

    public static void main(String[] args) {
        int result = new LeetCode312戳气球().maxCoins3(new int[]{3, 1, 5, 8});
        System.out.println(result);
    }
}
