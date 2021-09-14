package leetCode;

import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/16
 */
public class LeetCode524通过删除字母匹配到字典里最长单词 {

    /**
     * 检查字符串A是不是字符串B的子序列
     * A是否为B的子序列 则for循环时必须要把B循环完
     * 循环完后验证A字符串是否已经遍历完成
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSubString(String a, String b) {
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
     * 匹配字典最长单词 其实就是检查一个单词是否为另一个单词的子序列
     * 子序列：通过删减一些字符后 字符串相同 但是字符串内字母的前后顺序不变
     * 还得返回字典序更小的
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (int i = 0; i < dictionary.size(); i++) {
            if (isSubString(dictionary.get(i), s) && result.length() <= dictionary.get(i).length()) {
                if (result.length() == dictionary.get(i).length()) {
                    result = getLittleIndexOfString(result, dictionary.get(i));
                } else {
                    result = dictionary.get(i);
                }
            }
        }
        return result;
    }

    /**
     * 获取字典序更小的字符串
     * 两字符串长度相同时使用
     *
     * @param a
     * @param b
     * @return
     */
    public String getLittleIndexOfString(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() > b.length() ? b : a;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return a;
            } else if (a.charAt(i) > b.charAt(i)) {
                return b;
            }
        }
        return a;
    }
}
