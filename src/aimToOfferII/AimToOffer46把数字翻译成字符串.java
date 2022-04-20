package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/6
 */
public class AimToOffer46把数字翻译成字符串 {

    /**
     * 感觉就是dp
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                dp[i] = 1;
            } else {
                int single = dp[i - 1];
                int dou = 0;
                String subString = str.substring(i - 1, i + 1);
                int parse = Integer.parseInt(subString);
                if (parse >= 10 && parse < 26) {
                    dou = i - 1 == 0 ? 1 : dp[i - 2];
                }
                dp[i] = single + dou;
            }
        }
        return dp[str.length() - 1];
    }

    public static void main(String[] args) {
        int n = 25;
        int result = new AimToOffer46把数字翻译成字符串().translateNum(n);
        System.out.println(result);
    }
}
