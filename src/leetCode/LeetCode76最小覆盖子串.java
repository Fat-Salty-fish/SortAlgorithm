package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/2
 */
public class LeetCode76最小覆盖子串 {

    /**
     * 用于存放t的字符个数
     */
    Map<Character, Integer> tCharMap = new HashMap<>();

    /**
     * 用于存放s的字符个数
     */
    Map<Character, Integer> sCharMap = new HashMap<>();

    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        if (s.isEmpty()) {
            return "";
        }
        // 双指针 滑动窗口
        int left = 0;
        int right = -1;
        for (Character tChar : t.toCharArray()) {
            tCharMap.put(tChar, tCharMap.getOrDefault(tChar, 0) + 1);
        }
        int resultLeft = -1;
        int resultRight = -1;
        int length = Integer.MAX_VALUE;
        while (right < s.length()) {
            right++;
            if (right < s.length() && tCharMap.containsKey(s.charAt(right))) {
                extendSCharMap(s.charAt(right));
            }
            while (check() && left <= right) {
                if (right - left + 1 < length) {
                    length = right - left + 1;
                    resultLeft = left;
                    resultRight = left + length;
                }
                if (tCharMap.containsKey(s.charAt(left))) {
                    reduceSCharMap(s.charAt(left));
                }
                left++;
            }
        }
        return resultLeft == -1 ? "" : s.substring(resultLeft, resultRight);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : tCharMap.entrySet()) {
            if (!sCharMap.containsKey(entry.getKey()) || sCharMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void extendSCharMap(Character sChar) {
        sCharMap.put(sChar, sCharMap.getOrDefault(sChar, 0) + 1);
    }

    public void reduceSCharMap(Character sChar) {
        sCharMap.put(sChar, sCharMap.get(sChar) - 1);
        if (sCharMap.get(sChar) == 0) {
            sCharMap.remove(sChar);
        }
    }

    /**
     * 看labuladong 自写
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (Character character : t.toCharArray()) {
            tMap.put(character, tMap.getOrDefault(character, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int valid = 0;
        int resultLeft = -1;
        while (right < s.length()) {
            right++;
            Character rightChar = s.charAt(right - 1);
            if (tMap.containsKey(rightChar)) {
                sMap.put(rightChar, sMap.getOrDefault(rightChar, 0) + 1);
                if (sMap.get(rightChar).equals(tMap.get(rightChar))) {
                    valid++;
                }
            }
            while (valid == tMap.size() && left < right) {
                if (right - left < length) {
                    length = right - left;
                    resultLeft = left;
                }
                if (tMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                    if (sMap.get(s.charAt(left)) < tMap.get(s.charAt(left))) {
                        valid--;
                    }
                }
                left++;
            }
        }
        return resultLeft == -1 ? "" : s.substring(resultLeft, resultLeft + length);
    }


    /**
     * 三刷 双指针能否完成？应该是可以
     * 双指针 如果全部匹配了字符 则视为结果之一 那么如何继续遍历？left应该从哪一步开始继续向后遍历？
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow3(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        // 统计target需要的字符类型以及字符数量
        for (char temp : t.toCharArray()) {
            targetMap.put(temp, targetMap.getOrDefault(temp, 0) + 1);
        }
        int left = 0;
        int right = 0;
        String result = "";
        int match = t.length();
        int minLength = Integer.MAX_VALUE;
        while (right < s.length()) {
            targetMap.put(s.charAt(right), targetMap.getOrDefault(s.charAt(right), 0) - 1);
            if (targetMap.get(s.charAt(right)) >= 0) {
                match--;
            }
            if (match == 0) {
                while (targetMap.get(s.charAt(left)) < 0) {
                    targetMap.put(s.charAt(left), targetMap.get(s.charAt(left++)) + 1);
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                match++;
                targetMap.put(s.charAt(left), targetMap.get(s.charAt(left++)) + 1);
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : result;
    }


    public static void main(String[] args) {
        String a = "ADOBECODEBANC";
        String b = "ABC";
        String result = new LeetCode76最小覆盖子串().minWindow3(a, b);
        System.out.println(result);
    }
}
