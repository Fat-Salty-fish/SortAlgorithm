package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/21
 */
public class LeetCode368最大整除子集 {

    /**
     * 动态规划特训
     * 类似最长递增子序列
     *
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 先对数组进行排序
        Arrays.sort(nums);
        // 用于记录最大的整除子集的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        // 用于记录最大的整出子集的子集
        List<List<Integer>> pathDp = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        pathDp.add(first);
        // 用于返回结果
        List<Integer> result = first;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                // 第i位数可以添加到整除子集中
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        temp = new ArrayList<>(pathDp.get(j));
                    }
                }
            }
            temp.add(nums[i]);
            pathDp.add(temp);
            if (temp.size() > result.size()){
                result = temp;
            }
        }
        return result;
    }

    /**
     * 类似于最长递增子序列
     * 微软模拟面试 没做出来 。。。。
     * 难受
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        return null;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,8};
        List<Integer> result = new LeetCode368最大整除子集().largestDivisibleSubset(array);
        System.out.println("结果为");
    }
}
