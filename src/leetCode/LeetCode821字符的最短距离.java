package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/3
 */
public class LeetCode821字符的最短距离 {

    /**
     * 字符的最小距离
     *
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                left[i] = 0;
            } else if (i != 0 && left[i - 1] != -1) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                right[i] = 0;
            } else if (i != s.length() - 1 && right[i + 1] != -1) {
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (left[i] == -1) {
                result[i] = right[i];
            } else if (right[i] == -1) {
                result[i] = left[i];
            } else {
                result[i] = Math.min(left[i], right[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        char target = 'e';
        int[] result = new LeetCode821字符的最短距离().shortestToChar(str, target);
        System.out.println(result[0]);
    }
}
