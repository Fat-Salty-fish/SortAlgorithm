package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/22
 */
public class LeetCode647回文子串 {

    /**
     * 定义dp[i][j]
     * 表示字符串索引[i,j]之内的字符能形成的回文串的个数
     * 则 if(s.charAt(i) == s.charAt(j)){
     * // 此时形成了新的回文字符串
     * dp[i][j] = dp[i+1][j-1] +1;
     * }else{
     * // 没形成新的回文字符串
     * }
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int length = s.length();
//        int[][] dp = new int[length][length];
//        // base case 只有一个字符时也是回文字符串
//        for (int i = 0; i < length; i++) {
//            dp[i][i] = 1;
//        }
//        for (int i = 0; i < length; i++) {
//            for (int j = i + 1; j < length; j++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    dp[i][j] = dp[i + 1][j - 1] + 2;
//                } else {
//                    dp[i][j] = Math.max(Math.max(dp[i + 1][j], dp[i][j - 1]), dp[i + 1][j - 1]);
//                }
//            }
//        }
//        return dp[0][length - 1];

        boolean[][] boolDp = new boolean[length][length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            boolDp[i][i] = true;
            count++;
        }
        // 遍历方向是什么？ 因为最后结果是dp[0][length-1] 并且dp[i][j]和dp[i+1][j-1]/dp[i][j-1]/dp[i+1][j]有关 所以要从下网上 从左往右遍历
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (boolDp[i + 1][j - 1] || j - i <= 2) {
                        boolDp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String a = "aaa";
        int result = new LeetCode647回文子串().countSubstrings(a);
        System.out.println(result);
    }
}
