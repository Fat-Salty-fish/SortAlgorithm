package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/12
 */
public class LeetCode474一和零 {

    /**
     * 零和一
     * 很明显就是01背包问题了
     * 但是是3维数组
     * m个0和n个1
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        // 二进制字符串 如果m和n都为0则不可能有符合的字符串
        if (m == 0 && n == 0) {
            return 0;
        }
        // 动态规划数组
        // 在strs数组前x个计算内 取m个0和n个1时 最大的子集数量
        int[][][] dp = new int[strs.length][m + 1][n + 1];
//        // 预处理数组 大多数情况都是处理边界情况
//        // 如果只取第一个字符串 则最大子集数量取决于n和m
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                dp[0][i][j] = 0;
//            }
//        }
        // 如果m为0 或者 n为0 应该不需要处理什么数据
        // 如果m和n都为0 已经被过滤掉了
        // 是否选择这个字符串：
        // 如果选择字符串 则需要 dp[x-1][y-(此字符串的0的数量)][z-(此字符串的1的数量)] + 1
        // 如果不选择字符串 则需要dp[x-1][y][z]
        for (int x = 0; x < strs.length; x++) {
            int zeroNum = getZeroNums(strs[x]);
            int oneNum = getOneNums(strs[x]);
            for (int y = 0; y <= m; y++) {
                for (int z = 0; z <= n; z++) {
                    if (y - zeroNum >= 0 && z - oneNum >= 0) {
                        dp[x][y][z] = Math.max((x == 0 ? 0 : dp[x - 1][y - zeroNum][z - oneNum]) + 1, x == 0 ? 0 : dp[x - 1][y][z]);
                    } else {
                        dp[x][y][z] = (x == 0 ? 0 : dp[x - 1][y][z]);
                    }
                }
            }
        }
        return dp[strs.length - 1][m][n];
    }

    /**
     * 获得二进制字符串中0的个数
     *
     * @param str
     * @return
     */
    public int getZeroNums(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                num++;
            }
        }
        return num;
    }

    /**
     * 获得二进制字符串中1的个数
     *
     * @param str
     * @return
     */
    public int getOneNums(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String[] array = {"11111", "100", "1101", "1101", "11000"};
        int m = 5;
        int n = 7;
        int result = new LeetCode474一和零().findMaxForm(array, m, n);
        System.out.println(result);
    }
}
