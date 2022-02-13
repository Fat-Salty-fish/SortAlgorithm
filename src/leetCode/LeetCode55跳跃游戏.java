package leetCode;

/**
 * @author acer
 * @Date 2019/8/26 18:48
 */
public class LeetCode55跳跃游戏 {
    enum index {
        GOOD, BAD, UNKNOWN
    }

    index[] memory;

    public boolean canJump(int[] nums) {
        memory = new index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memory[i] = index.UNKNOWN;
        }
        memory[nums.length - 1] = index.GOOD;
        return caculate(nums, 0);
    }

    public boolean caculate(int[] nums, int position) {
        if (memory[position] != index.UNKNOWN) {
            return memory[position] == index.GOOD ? true : false;
        }
        //可以跳到的最远距离
        int futherJump = Math.min(position + nums[position], nums.length - 1);
        for (int i = position + 1; i <= futherJump; i++) {
            if (caculate(nums, i)) {
                memory[position] = index.GOOD;
                return true;
            }
        }
        memory[position] = index.BAD;
        return false;
    }

    public boolean Jump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    /**
     * 动态规划尝试
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        dp[1] = true;
        for (int i = 2; i <= nums.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i] || (dp[j] && (j - 1 + nums[j - 1] >= i - 1));
            }
        }
        return dp[nums.length];
    }

    /**
     * 标准答案 贪心算法
     *
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            if (i + nums[i] >= length - 1) {
                return true;
            }
            max = Math.max(max, i + nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1};
        boolean result = new LeetCode55跳跃游戏().canJump2(array);
        System.out.println(result);
    }
}
