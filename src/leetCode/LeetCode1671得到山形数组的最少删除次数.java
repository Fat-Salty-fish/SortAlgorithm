package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/7
 */
public class LeetCode1671得到山形数组的最少删除次数 {

    /**
     * 微软模拟面试
     * 必须先学会LIS的二分查找解法 再来解决这个问题
     *
     * @param nums
     * @return
     */
    public int minimumMountainRemovals(int[] nums) {
        int result = Integer.MAX_VALUE;
        int[] leftDp = new int[nums.length];
        int[] leftLengthDp = new int[nums.length];
        int leftLength = 0;
        // 从左到右遍历统计lis
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int index = searchLeft(leftLengthDp, currentNum, leftLength);
            if (index == leftLength) {
                leftLength++;
            }
            leftLengthDp[index] = currentNum;
            leftDp[i] = leftLength;
        }

        int[] rightDp = new int[nums.length];
        int[] rightLengthDp = new int[nums.length];
        int rightLength = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int currentNum = nums[i];
            int index = searchLeft(rightLengthDp, currentNum, rightLength);
            if (index == rightLength) {
                rightLength++;
            }
            rightLengthDp[index] = currentNum;
            rightDp[i] = rightLength;
        }
        // 统计最长递增长度
        for (int i = 1; i < nums.length - 1; i++) {
            int left = leftDp[i];
            int right = rightDp[i];
            // 两个长度有1时 只有当前元素 不能够使用计算
            if (left == 1 || right == 1) {
                continue;
            }
            result = Math.min(result, nums.length - (left + right - 1));
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 二分查找
     * 寻找比target大的第一个值
     * 即寻找左边界
     *
     * @param nums
     * @param target
     * @param lastIndex
     * @return
     */
    public int searchLeft(int[] nums, int target, int lastIndex) {
        int left = 0;
        int right = lastIndex;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64};
        int result = new LeetCode1671得到山形数组的最少删除次数().minimumMountainRemovals(array);
        System.out.println("结果为:" + result);
    }
}
