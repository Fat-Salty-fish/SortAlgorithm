package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/26
 */
public class AimToOfferII45把数字翻译成字符串 {

    /**
     * dp函数开辟了长度为n的数组
     * 可以优化到O(1)
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if (num < 0) {
            return 0;
        }
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= numStr.length(); i++) {
            int single = numStr.charAt(i - 1) - '0';
            if (single >= 0) {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && numStr.charAt(i - 2) != '0') {
                int dou = Integer.parseInt(numStr.substring(i - 2, i));
                if (dou <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[numStr.length()];
    }

    public static void main(String[] args) {
        int num = 0;
        int result = new AimToOfferII45把数字翻译成字符串().translateNum(num);
        System.out.println(result);
    }
}
