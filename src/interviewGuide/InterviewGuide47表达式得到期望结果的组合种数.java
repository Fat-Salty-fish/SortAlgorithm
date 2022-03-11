package interviewGuide;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/26
 */
public class InterviewGuide47表达式得到期望结果的组合种数 {

    public int expressionCombine(String expression, boolean target) {
        // 表达式不通过 无法生成目标
        if (!checkExpression(expression)) {
            return 0;
        }
        // 表示从i-j的字符串能够表示true/false的方法有dp个
        int[][][] dp = new int[expression.length()][expression.length()][2];
        // 如何初始化？ i = j 并且i和j必须是偶数
        for (int i = 0; i < expression.length(); i += 2) {
            dp[i][i][0] = expression.charAt(i) == '0' ? 1 : 0;
            dp[i][i][1] = expression.charAt(i) == '1' ? 1 : 0;
        }
        // 根据符号进行划分 还是没有理解了题意
        // 如何遍历dp数组？应该从右下角开始往右上角遍历
        for (int i = expression.length() - 3; i >= 0; i -= 2) {
            for (int j = i + 2; j < expression.length(); j += 2) {
                for (int k = i + 1; k < expression.length(); k += 2) {
                    char symbol = expression.charAt(k);
                    if (symbol == '^') {
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0] + dp[i][k - 1][1] * dp[k + 1][j][1];
                        dp[i][j][1] += dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0];
                    } else if (symbol == '|') {
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][0] + dp[i][k - 1][1] * dp[k + 1][j][1] + dp[i][k - 1][0] * dp[k + 1][j][1];
                    } else if (symbol == '&') {
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][1];
                    }
                }
            }
        }
        return dp[0][expression.length() - 1][target ? 1 : 0];
    }

    /**
     * 检查表达式是否正确
     *
     * @param expression
     * @return
     */
    public boolean checkExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            return false;
        }
        if (expression.length() % 2 == 0) {
            return false;
        }
        for (int i = 0; i < expression.length(); i++) {
            // 偶数的时候必须是数字 1或者0里的一个
            if (i % 2 == 0) {
                if (!(expression.charAt(i) == '0' || expression.charAt(i) == '1')) {
                    return false;
                }
            } else {
                if ((expression.charAt(i) != '^') && (expression.charAt(i) != '|') && (expression.charAt(i) != '&')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String expression = "1";
        boolean target = false;
        int result = new InterviewGuide47表达式得到期望结果的组合种数().expressionCombine(expression, target);
        System.out.println(result);
    }
}
