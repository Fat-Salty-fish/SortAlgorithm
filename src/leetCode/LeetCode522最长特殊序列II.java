package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/15
 */
public class LeetCode522最长特殊序列II {

    /**
     * 判断A字符串是否为B字符串的子序列
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSubSequence(String a, String b) {
        int indexA = 0;
        int indexB = 0;
        for (; indexA < a.length() && indexB < b.length(); indexB++) {
            if (a.charAt(indexA) == b.charAt(indexB)) {
                indexA++;
            }
        }
        return indexA == a.length();
    }

    /**
     * 暴力法
     * 获取最长非子序列字符串
     *
     * @param strs
     * @return
     */
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isNotSub = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubSequence(strs[i], strs[j])) {
                    isNotSub = false;
                    break;
                }
            }
            if (isNotSub){
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String a = "aa";
        String b = "aaa";
        boolean result = new LeetCode522最长特殊序列II().isSubSequence(a,b);
    }
}
