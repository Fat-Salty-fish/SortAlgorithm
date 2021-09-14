package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/22
 */
public class LeetCode72编辑距离 {

    /**
     * 编辑距离
     * 暴力解法
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        return dp(word1, word1, word1.length() - 1, word2.length() - 1);
    }

    /**
     * dp方法运算长度为a和长度为b时
     * 需要的次数
     *
     * @param wordA a单词
     * @param wordB b单词
     * @param a     a单词索引 从0到wordA-1
     * @param b     b单词索引 从0到wordB-1
     * @return
     */
    public int dp(String wordA, String wordB, int a, int b) {
        // basecase
        // 第一个单词遍历结束了 只需要再插入剩余的第二个单词的字符即可 需要操作b+1次
        if (a == -1) {
            return b + 1;
        }
        // 第二个单词遍历结束了 只需要删除剩余的第一个单词的字符即可 需要操作a+1次
        if (b == -1) {
            return a + 1;
        }
        // 两字符相同 直接跳过
        if (wordA.charAt(a) == wordB.charAt(b)) {
            return dp(wordA, wordB, a - 1, b - 1);
        } else {
            // 两字符不相同 则可以删除 替换 插入
            // 删除时 结果为dp(i-1,j)+1
            // 插入时 结果为dp(i,j-1)+1
            // 替换时 结果为dp(i-1,j-1)+1
            // 从这看 dp(i,j) 和dp(i-1,j) dp(i,j-1) 和dp(i-1,j-1)有关系
            return Math.min(Math.min(dp(wordA, wordB, a - 1, b) + 1, dp(wordA, wordB, a, b - 1) + 1), dp(wordA, wordB, a - 1, b - 1) + 1);
        }
    }

    /**
     * 动态规划优化
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance2(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化 当i和j分别为0时 dp[0][....] dp[...][0]分别为多少
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    /**
     * 动态规划优化
     * 压缩dp规模
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance3(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        // 初始化 因为只记录了第一行 相当于二维数组的第一行 dp[0][...]
        // 第一列不再需要预处理
        for (int j = 0; j < word2.length(); j++) {
            dp[j] = j;
        }
        // 处理dp
        for (int i = 1; i <= word1.length(); i++) {
            int pre = 0;
            for (int j = 1; j <= word2.length(); j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = pre;
                } else {
                    dp[j] = minOfThreeNums(dp[j - 1], dp[j], pre) + 1;
                }
                pre = temp;
            }
        }
        return dp[word2.length()];
    }

    /**
     * 返回三个数字中最小的数字
     *
     * @param num1
     * @param num2
     * @param num3
     * @return
     */
    public int minOfThreeNums(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }
}
