package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    /**
     * 动态规划？
     * 设dp[i][j]表示s中i位置之后j字符第一次出现的位置
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord2(String s, List<String> dictionary) {
        int length = s.length();
        int[][] sIndex = new int[length + 1][26];
        Arrays.fill(sIndex[length], length);
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) - 'a' == j) {
                    sIndex[i][j] = i;
                } else {
                    sIndex[i][j] = sIndex[i + 1][j];
                }
            }
        }

        String result = "";
        for (String current : dictionary) {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < current.length(); i++) {
                if (sIndex[j][current.charAt(i) - 'a'] == length) {
                    match = false;
                    break;
                }
                j = sIndex[j][current.charAt(i) - 'a'] + 1;
            }
            if (match){
                if (current.length() > result.length() || (current.length() == result.length() && current.compareTo(result) < 0)){
                    result = current;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "abpcplea";

        String[] array = {"ale","apple","monkey","plea"};
        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        String result = new LeetCode524通过删除字母匹配到字典里最长单词().findLongestWord2(a,list);
        System.out.println(result);
    }
}
