package leetCode;

/**
 * @author acer
 * @Date 2019/8/24 12:17
 */
public class LeetCode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ++temp;
            } else {
                ans = Math.max(ans,temp);
                temp = 0;
            }
        }
        return Math.max(temp,ans);
    }
}
