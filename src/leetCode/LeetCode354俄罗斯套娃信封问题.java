package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/21
 */
public class LeetCode354俄罗斯套娃信封问题 {

    /**
     * 俄罗斯套娃信封问题
     * 二维动态规划
     * 注意 只能用已存在的信封相互嵌套 不能用固定的长和宽假设信封
     * 假设知道了以第i-1个信封为结尾时能嵌套多少个信封 则第i个信封为结尾的嵌套个数为 dp[i] = max(dp[0],...,dp[i-1])+1(如果最后一个信封可以包括进前面的信封里)
     * 状态：解决这个问题需要几个状态？ 只需要一个状态 用于dp时保存
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        // 对原数组进行排序 排序之后使用LIS方法计算即可
        // 为什么？这个问题可以转换为最长递增子序列问题
        // 但是问题在于这个问题相关参数有两个值 无法直接用最长递增子序列
        // 所以先对原数组进行排序 如何排序？对一个参数增序排序 相等时对另一个参数逆序排序
        // 为什么？在长/宽一个参数相同时 只能选一个相同长/宽参数下的信封 此时尽量选择另外一个参数最小的信封 使得另一个参数不影响最终结果
        // 如何跳过长/宽相同时的信封？
        // 排序
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        // 信封个数
        int numOfEnvelopes = envelopes.length;
        int[] dp = new int[numOfEnvelopes];
        dp[0] = 1;
        int maxNum = 1;
        // 动态规划
        for (int i = 1; i < numOfEnvelopes; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 这里如何跳过相同长/宽的信封？
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxNum = Math.max(maxNum, dp[i]);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[][] array = {{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        int result = new LeetCode354俄罗斯套娃信封问题().maxEnvelopes(array);
        System.out.println(result);
    }
}
