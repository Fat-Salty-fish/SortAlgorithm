package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/23
 */
public class LeetCode1055形成字符串的最短路径 {

    /**
     * 动态规划特训
     * 形成字符串的最短路径
     * 先要理解题目：
     * 判断b字符串能否由a字符串以及a字符串的子序列组成
     * 如果能组成 如果能组成 则返回由a子序列组成b字符串时的最小部分数
     * @param source
     * @param target
     * @return
     */
    public int shortestWay(String source, String target) {
        if (source.equals(target)) {
            return 1;
        }
        // 若target字符串中有source字符串没有的字符 则无法由source组成target 返回-1
        for (int i = 0; i < target.length(); i++) {
            if (!source.contains(target.substring(i, i + 1))) {
                return -1;
            }
        }
        int targetLength = target.length();
        int[] dp = new int[targetLength];
        dp[0] = 1;
        int currentLeft = 0;
        for (int i = 1; i < targetLength; i++) {
            if (isSubString(source, target.substring(currentLeft, i + 1))) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + 1;
                currentLeft = i;
            }
        }
        return dp[targetLength - 1];
    }

    /**
     * 判断b字符串是否为a字符串的子序列
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSubString(String a, String b) {
        int indexOfA = 0;
        int indexOfB = 0;
        while (indexOfA < a.length() && indexOfB < b.length()) {
            // 如果字符相同 则指针同时前进
            if (a.charAt(indexOfA) == b.charAt(indexOfB)) {
                indexOfA++;
                indexOfB++;
            } else {
                // 否则 只有a向前
                indexOfA++;
            }
        }
        return indexOfB == b.length();
    }


    public static void main(String[] args) {
        String source = "xyz";
        String target = "xzyxz";
        int result = new LeetCode1055形成字符串的最短路径().shortestWay(source, target);
        System.out.println("结果" + result);
    }
}
