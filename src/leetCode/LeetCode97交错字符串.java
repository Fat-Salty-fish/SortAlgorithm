package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/1
 */
public class LeetCode97交错字符串 {

    /**
     * 三指针？ 试试吧 看评论不太行
     * 动态规划
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] check = new boolean[s1.length() + 1][s2.length() + 1];
        check[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                int position = i + j - 1;
                if (i >= 1) {
                    char s1Char = s1.charAt(i - 1);
                    check[i][j] = check[i][j] || (check[i - 1][j] && (s3.charAt(position) == s1Char));
                }
                if (j >= 1) {
                    char s2Char = s2.charAt(j - 1);
                    check[i][j] = check[i][j] || (check[i][j - 1] && (s3.charAt(position) == s2Char));
                }
            }
        }
        return check[s1.length()][s2.length()];
    }
}
