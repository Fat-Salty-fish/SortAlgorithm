package competition;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/9
 */
public class LeetCode5977最少交换次数来组合所有的1II {

    public int minSwaps(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int oneNums = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                oneNums++;
            }
        }

        int[] doubleNums = new int[2 * nums.length];
        for (int i = 0; i < 2 * nums.length; i++) {
            doubleNums[i] = nums[i % nums.length];
        }

        int max = 0;
        int left = 0;
        int right = 0;
        int temp = 0;
        while (right < doubleNums.length) {
            if (doubleNums[right] == 1) {
                temp++;
            }
            if (right - left + 1 > oneNums) {
                if (doubleNums[left] == 1) {
                    temp--;
                }
                left++;
            }
            max = Math.max(max, temp);
            right++;
        }
        return oneNums - max;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0, 0};
        int result = new LeetCode5977最少交换次数来组合所有的1II().minSwaps(nums);
    }
}
