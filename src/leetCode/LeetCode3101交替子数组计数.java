package leetCode;

public class LeetCode3101交替子数组计数 {
    /**
     * 动态规划？
     * 用二维数组维护这个开头和结尾的数组是否为有效的子数组
     *
     * @param nums
     * @return
     */
    public long countAlternatingSubarrays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        long result = 0;
        int length = nums.length;
        int currentStart = 0;
        for (int currentRight = 1; currentRight <= length; currentRight++) {
            if (currentRight == length || nums[currentRight] == nums[currentRight - 1]) {
                result += calculate(currentStart, currentRight - 1);
                currentStart = currentRight;
            }
        }
        return result;
    }

    /**
     * 计算个数
     *
     * @param left
     * @param right
     * @return
     */
    public long calculate(int left, int right) {
        if (left == right) {
            return 1;
        }
        int n = (right - left) + 1;
        return ((long) (1 + n) * n) / 2;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 1};
        long result = new LeetCode3101交替子数组计数().countAlternatingSubarrays(nums);
        System.out.printf(String.valueOf(result));
    }

}
