package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/2
 */
public class LeetCode567字符串的排列 {


    /**
     * 即判断 s2中是否存在一个子串 包含s1的所有字符并且不存在其他字符
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (Character s1Char : s1.toCharArray()) {
            need.put(s1Char, need.getOrDefault(s1Char, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            right++;
            Character currentRight = s2.charAt(right - 1);
            if (need.containsKey(currentRight)) {
                windows.put(currentRight, windows.getOrDefault(currentRight, 0) + 1);
                if (need.get(currentRight).equals(windows.get(currentRight))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                Character currentLeft = s2.charAt(left);
                if (need.containsKey(currentLeft)) {
                    if (need.get(currentLeft).equals(windows.get(currentLeft))) {
                        valid--;
                    }
                    windows.put(currentLeft, windows.get(currentLeft) - 1);
                }
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "trinitrophenylmethylnitramine";
        String s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
        boolean have = new LeetCode567字符串的排列().checkInclusion(s1, s2);
        System.out.println(have);
    }
}
