package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode315计算右侧小于当前元素的个数 {

    /**
     * 暴力解法 O(n平方)
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = 0;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp[i]++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.add(dp[i]);
        }
        return result;
    }


    List<Integer> contributeList = new ArrayList<>();


    /**
     * 归并排序时的帮助数组
     */
    int[] help;

    /**
     * 索引数组
     */
    int[] index;

    /**
     * 记录每个位置的逆序对数
     */
    int[] count;

    /**
     * 归并排序 + 索引数组
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller2(int[] nums) {
        int length = nums.length;
        help = new int[length];
        index = new int[length];
        count = new int[length];
        for (int i = 0; i < length; i++) {
            index[i] = i;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(i, count[i]);
        }
        return result;
    }

    /**
     * 归并排序 排序结果写在help中
     */
    public void sortAndCount(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sortAndCount(nums, start, mid);
        sortAndCount(nums, mid + 1, end);
        // 归并排序的优化 如果已经有序了 则不需要再排序了
        if (nums[mid] < nums[mid + 1]) {
            return;
        }
        mergeTwoSortedArray(nums, start, mid, end);
    }

    /**
     * 归并排序的一部分 将两个有序数组合并到一个数组中
     *
     * @param nums
     * @param leftStart
     * @param mid
     * @param rightEnd
     */
    public void mergeTwoSortedArray(int[] nums, int leftStart, int mid, int rightEnd) {
        for (int i = leftStart; i <= rightEnd; i++) {
            help[i] = index[i];
        }
        int i = leftStart;
        int j = mid + 1;
        for (int k = leftStart; k <= rightEnd; k++) {
            if (i > mid) {
                index[k] = help[j];
                j++;
            } else if (j > rightEnd) {
                index[k] = help[i];
                i++;
                count[index[k]] += (rightEnd - mid);
            } else if (nums[help[i]] <= nums[help[j]]) {
                index[k] = help[i];
                i++;
                count[index[k]] += (j - mid - 1);
            } else {
                index[k] = help[j];
                j++;
            }
        }
    }


    /**
     * 用来保存原始值以及原始位置
     */
    class Pair {
        public int value;
        public int originalIndex;

        public Pair() {
        }

        public Pair(int x, int y) {
            value = x;
            originalIndex = y;
        }
    }

    /**
     * 用于保存在归并排序过程中的第i个元素的逆序对
     */
    int[] resultCount;

    /**
     * 排序结果
     */
    Pair[] sortResult;

    /**
     * 包装类
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller3(int[] nums) {
        int length = nums.length;
        Pair[] pairs = new Pair[length];
        resultCount = new int[length];
        sortResult = new Pair[length];
        for (int i = 0; i < length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        sort(pairs, 0, length - 1);
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < resultCount.length; i++) {
            resultList.add(resultCount[i]);
        }
        return resultList;
    }

    /**
     * 对nums进行排序
     *
     * @param nums
     * @param left
     * @param right
     */
    public void sort(Pair[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        if (nums[mid].value < nums[mid + 1].value) {
            return;
        }
        merge(nums, left, mid, right);
    }

    public void merge(Pair[] nums, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        for (int k = left; k <= right; k++) {
            if (leftIndex > mid) {
                sortResult[k] = nums[rightIndex];
                rightIndex++;
            } else if (rightIndex > right) {
                sortResult[k] = nums[leftIndex];
                resultCount[nums[leftIndex].originalIndex] += right - mid;
                leftIndex++;
            } else if (nums[leftIndex].value <= nums[rightIndex].value) {
                sortResult[k] = nums[leftIndex];
                resultCount[nums[leftIndex].originalIndex] += rightIndex - mid - 1;
                leftIndex++;
            } else if (nums[leftIndex].value > nums[rightIndex].value) {
                sortResult[k] = nums[rightIndex];
                rightIndex++;
            }
        }
        for (int k = left; k <= right; k++) {
            nums[k] = sortResult[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = new LeetCode315计算右侧小于当前元素的个数().countSmaller3(nums);
        System.out.println(result.size());
    }
}
