package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/17
 */
public class LeetCode376摆动序列 {

    /**
     * 动态规划特训
     * 子序列？
     * 应该定义dp[i][j] 表示以i结尾的子序列的最长摆动序列长度
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1] ? 1 : 2;
        }
        // 用来记录上升摆动序列 以前i个元素组成的序列并且序列末端是上升情况下 最长序列长度
        int up[] = new int[nums.length];
        // 用来记录下降摆动序列 以前i个元素组成的序列并且序列末端是下降情况下 最长序列长度
        int down[] = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            } else if (nums[i] > nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            } else {
                up[i] = Math.max(down[i - 1] + 1, up[i - 1]);
                down[i] = down[i - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, Math.max(up[i], down[i]));
        }
        return max;
    }
}
