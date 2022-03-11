package leetCode;

/**
 * @author lizhongjie
 * @desc 动态规划训练 最长递增子序列
 * @create_time 2021/8/21
 */
public class LeetCode300最长递增子序列 {

    /**
     * 最长递增子序列 如何运算？
     * 问题拆解
     * 状态定义
     * 递归方程推导
     * 实现
     * <p>
     * 第一步 问题拆解 在计算最长递增子序列时 需要知道前面的递增子序列长度 递增子序列里最后一个数字是多少
     * 第二步 状态定义 由问题拆解看 需要两个状态 一是数组位置 二是是否选择当前数字
     * 第三步
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        // 没有其他办法 只能每一次都遍历一次数组
        int[] dp = new int[nums.length];
        // 初始化 也就是base case
        dp[0] = 1;
        int currentMax = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            currentMax = Math.max(currentMax, dp[i]);
        }

        return currentMax;
    }

    /**
     * 动态规划特训
     * 二刷
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 第i位前的最长递增子序列 起码有1位
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = 1;
            // 优化 这里可以优化成二分查找 查找出来最大的数 算法时间复杂度可以降低为nlogn
            for (int j = 1; j <= i - 1; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 用二分查找解决LIS问题
     * 修改dp定义：dp[i]表示长度为i时的递增子序列的最后一个元素值为多少
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS4(int[] nums) {
        int numLength = nums.length;
        int lastIndex = 0;
        int[] dp = new int[numLength];

        for (int i = 0; i < numLength; i++) {
            int currentNum = nums[i];
            int index = findIndexOfFirstBiggerThanTarget(dp, currentNum, lastIndex);
            if (index == lastIndex) {
                lastIndex++;
            }
            dp[index] = currentNum;
        }
        return lastIndex;
    }

    /**
     * 这里找的是什么数？
     * 找的应该是第一个比target大的元素 这是寻找左边界还是寻找右边界？
     * 应该是寻找左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int findIndexOfFirstBiggerThanTarget(int[] nums, int target, int lastIndex) {
        int left = 0;
        int right = lastIndex;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 5刷最长递增子序列 每次做都有新的体会
     * 学习连接：https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
     * 二分查找：找到比A[i]小的最大值的已有序列
     * 用一个tail[]数组来保存已有序列的最后一个元素
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS5(int[] nums) {
        int length = nums.length;
        int[] tailTable = new int[length];
        tailTable[0] = nums[0];
        // 永远指向空闲区域
        int freeIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            // 如果当前值是最大值 则新建一个序列
            if (currentNum > tailTable[freeIndex - 1]) {
                tailTable[freeIndex++] = currentNum;
            } else if (currentNum <= tailTable[0]) {
                tailTable[0] = currentNum;
            } else {
                int index = getIndex(tailTable, currentNum, 0, freeIndex - 1);
                if (index >= 0) {
                    tailTable[index + 1] = currentNum;
                }
            }
        }
        return freeIndex;
    }

    /**
     * 在min和max这俩index之间找到比target小的最大的值 这样就可以保证有序?
     *
     * @param array
     * @param target
     * @param min
     * @param max
     * @return
     */
    public int getIndex(int[] array, int target, int min, int max) {
        int left = min;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 7, 8};
        int length = new LeetCode300最长递增子序列().lengthOfLIS5(nums);
        System.out.println(nums[length]);
    }
}
