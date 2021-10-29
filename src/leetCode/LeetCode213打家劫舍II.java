package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/14
 */
public class LeetCode213打家劫舍II {


    /**
     * 数组变成了一个环
     * 所以选择了第一个数就不能选择最后一个数
     * 选择了最后一个数就不能选择第一个
     * 只要比较rob(nums[0,nums.length-2]和rob(nums[1,nums.length-1])后取更大者即可
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(help(nums, 0, nums.length - 2), help(nums, 1, nums.length - 1));
    }

    public int help(int[] nums, int startIndex, int endIndex) {
        if (nums == null || nums.length == 0 || startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return nums[startIndex];
        }
        int firstNum = 0;
        int secondNum = nums[startIndex];
        int temp = secondNum;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            temp = Math.max(secondNum, firstNum + nums[i]);
            firstNum = secondNum;
            secondNum = temp;
        }
        return temp;
    }

    /**
     * 二刷打家劫舍II
     * 动态规划特训
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(robHelp(nums, 0, nums.length - 2), robHelp(nums, 1, nums.length - 1));
    }


    public int robHelp(int[] nums, int startIndex, int endIndex) {
        if (nums == null || nums.length == 0 || startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return nums[startIndex];
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex > nums.length - 1) {
            endIndex = nums.length - 1;
        }
        int firstNum = 0;
        int secondNum = nums[startIndex];
        int result = 0;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            result = Math.max(firstNum + nums[i], secondNum);
            firstNum = secondNum;
            secondNum = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int result = new LeetCode213打家劫舍II().rob(nums);
    }
}
