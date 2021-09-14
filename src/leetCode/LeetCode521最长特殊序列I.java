package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/16
 */
public class LeetCode521最长特殊序列I {

    /**
     * "最长的特殊序列"
     * 被题目蒙蔽了 其实最长特殊序列就是指原字符串 原字符串不能是其他字符串的子序列
     * 所以只要两个字符串不相同 取更长的那一个就行
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b)){
            return -1;
        }
        return Math.max(a.length(),b.length());
    }
}
