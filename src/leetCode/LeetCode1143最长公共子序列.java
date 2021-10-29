package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/22
 */
public class LeetCode1143最长公共子序列 {

    /**
     * 最长公共子序列
     * 拆解问题 定义dp[i][j] 表示a字符串前i位和b字符串前j位时子序列长度
     * 状态定义 i和j 分别表示两字符串的位置
     * 状态转移方程 dp(i,j) = dp(i-1,j-1) + 1 (text1.charAt(i) == text2.charAt(j)
     * = Math.max(dp(i-1,j),dp(i,j-1)
     * 可以优化为一维dp
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // 初始化dp dp[0][...] 和dp[...][0]都应该为0
        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }
        // 从状态转移方程来看 涉及到的数只和上一行的数和这一行前一个数相关 尝试优化为一维
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    /**
     * 动态规划 二维dp优化为一维dp
     * 必须要一个一维数组和一个单独的数用来记录上一个数
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()) {
            return 0;
        }
        // 一维数组最短可以为 Math.min(text1.length(),text2.length())+1
        int[] dp = new int[text2.length() + 1];
        dp[0] = 0;
        for (int i = 1; i <= text1.length(); i++) {
            // 用于保存记录dp[j-1]
            int pre = 0;
            for (int j = 1; j <= text2.length(); j++) {
                // 记录修改之前上一行的dp[j] 本次j执行完后会会作为dp[j-1]保存
                int temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 此时的pre相当于dp[j-1]
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                // 一次for循环之后 更新dp[j-1]
                pre = temp;
            }
        }
        return dp[text2.length()];
    }


    /**
     * 动态规划特训
     * 二刷
     * 定义dp[i][j]
     * 表示a字符串前i个字符、b字符串前j个字符下
     * 最长子序列的长度
     * 状态转移方程:
     * if(a.charAt(i] == b.charAt(j))
     * dp[i][j] = dp[i-1][j-1] + 1;
     * else
     * dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence3(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
//        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//        // base case i/j分别为0时 没有字符能够匹配 均为0
//        for (int i = 1; i <= text1.length(); i++) {
//            for (int j = 1; j <= text2.length(); j++) {
//                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    // 两字符相同时 dp[i][j] = dp[i-1][j-1] + 1 表示 不计算这两个字符的时候的最长子序列的长度 + 1
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    // 两字符不相同时 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) 表示 等于不计算这两个字符任意一个字符的最长子序列的大小
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[text1.length()][text2.length()];
        // 简化为一维dp
        int[] dp = new int[text2.length() + 1];
        // base case j = 0 时 dp[0] = 0 无须初始化

        for (int i = 1; i <= text1.length(); i++) {
            int pre = 0;
            for (int j = 1; j <= text2.length(); j++) {
                int temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                pre = temp;
            }
        }
        return dp[text2.length()];
    }

    public static void main(String[] args) {
        String a = "abce";
        String b = "def";
        int result = new LeetCode1143最长公共子序列().longestCommonSubsequence(a, b);
        System.out.println(result);
    }
}
