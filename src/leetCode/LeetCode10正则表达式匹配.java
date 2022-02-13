package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/1
 */
public class LeetCode10正则表达式匹配 {


    public boolean isMatch(String s, String p) {
        int indexOfLeft = 0;
        int indexOfRight = 0;
        while (indexOfLeft < s.length() && indexOfRight < p.length()) {
            Character targetChar = s.charAt(indexOfLeft);
            if (p.charAt(indexOfRight) == targetChar) {
                indexOfLeft++;
                indexOfRight++;
            } else if (p.charAt(indexOfRight) == '.') {
                indexOfLeft++;
                indexOfRight++;
            } else if (p.charAt(indexOfRight) == '*') {
                // 前面没字符了 不知道该如何匹配
                if (indexOfRight == 0) {
                    return false;
                } else if (p.charAt(indexOfRight - 1) == '.') {
                    indexOfLeft++;
                } else if (p.charAt(indexOfRight - 1) == targetChar) {
                    indexOfLeft++;
                } else {
                    indexOfRight++;
                }
            } else {
                indexOfRight++;
            }
        }
        // 判断目标字符串是否已经遍历完了
        if (indexOfLeft < s.length()) {
            return false;
        }
        if (indexOfRight < p.length() && (p.charAt(indexOfRight) == '*' || p.charAt(indexOfRight) == '.')) {
            indexOfRight++;
        }
        while (indexOfRight < p.length()) {
            if (!(p.charAt(indexOfRight) == '*' || p.charAt(indexOfRight) == '.')) {
                return false;
            }
            indexOfRight++;
        }
        return true;
    }

    /**
     * dfs
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        System.out.println("s:" + s + ",p:" + p);
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() == 0) {
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch2(s, p.substring(2));
            } else {
                return false;
            }
        }
        if (p == null || p.length() == 0) {
            return false;
        }
        Character targetChar = s.charAt(0);
        if (p.charAt(0) == targetChar || p.charAt(0) == '.') {
            if (p.length() < 2) {
                return isMatch2(s.substring(1), p.substring(1));
            } else if (p.charAt(1) == '*') {
                return isMatch2(s.substring(1), p) || isMatch2(s.substring(1), p.substring(2)) || isMatch2(s, p.substring(2));
            } else {
                return isMatch2(s.substring(1), p.substring(1));
            }
        }
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch2(s, p.substring(2));
        }
        return false;
    }

    /**
     * 动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch3(String s, String p) {
        int targetLength = s.length();
        int patternLength = p.length();
        boolean[][] dp = new boolean[targetLength + 1][patternLength + 1];
        // 边界情况
        dp[0][0] = true;
        // s.length = 0时的默认情况
        for (int i = 1; i <= patternLength; i++) {
            // 下一个字符为'*'时 不用考虑当前字符是什么
            if (i <= patternLength - 1 && p.charAt(i) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = false;
            }
        }
        // p.length = 0 时的情况 s不为空 pattern为空 此时一定为false
        for (int i = 1; i <= targetLength; i++) {
            dp[i][0] = false;
        }
        // 构建dp
        for (int i = 1; i <= targetLength; i++) {
            for (int j = 1; j <= patternLength; j++) {
                Character targetChar = s.charAt(i - 1);
                Character currentPatternChar = p.charAt(j - 1);
                // 能够匹配到
                if (targetChar.equals(currentPatternChar) || currentPatternChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentPatternChar.equals('*')) {
                    if (targetChar.equals(p.charAt(j - 2)) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j - 2] || dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[targetLength][patternLength];
    }

    public static void main(String[] args) {
        String str = "aa";
        String match = "ab*ac*";
        boolean check = new LeetCode10正则表达式匹配().isMatch3(str, match);
        System.out.println(check);
    }
}
