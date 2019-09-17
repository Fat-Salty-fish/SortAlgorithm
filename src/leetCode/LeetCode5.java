package leetCode;

import sun.security.util.Length;

/**
 * @author acer
 * @Date 2019/7/30 22:44
 */
public class LeetCode5 {
    //动态规划 使用一个boolean的二维数组用来储存
    //boolean[][] 表示在i开头和j结尾的字符串是一个回文字符串
    public String longestPalindrome(String s) {
        if(s == null|| s.length() == 0){
            return "";
        }
        int length = s.length();
        char[] in = s.toCharArray();
        //一个二维数组 用来维护某个字符串是否为回文
        boolean[][] judgmengt = new boolean[length][length];
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (i == 0) {
                    judgmengt[j][j] = true;
                } else if(i == 1){
                    if(in[j] == in[j+1]){
                        judgmengt[j][j+1] = true;
                    }
                } else {
                    if(in[j] == in[j+i] && judgmengt[j+1][j+i-1] ){
                        judgmengt[j][j+i] = true;
                    }
                }
                if(judgmengt[j][j+i]){
                    start = j;
                    end = j+i;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    //暴力法
    public String force(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        String longestString = new String("");
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                boolean tem = test(temp);
                if(tem && temp.length() > longestString.length()){
                    longestString = temp;
                }
            }
        }
        return longestString;
    }

    public boolean test(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode5().force("babad"));
    }

}
