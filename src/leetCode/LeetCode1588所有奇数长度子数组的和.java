package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/10
 */
public class LeetCode1588所有奇数长度子数组的和 {

    /**
     * 微软面试模拟
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int length = 1; i + length <= arr.length; length += 2) {
                int end = i + length - 1;
                result += dp[end + 1] - dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 2, 5, 3};
        int result = new LeetCode1588所有奇数长度子数组的和().sumOddLengthSubarrays(array);
        System.out.println("结果为:" + result);
    }
}
