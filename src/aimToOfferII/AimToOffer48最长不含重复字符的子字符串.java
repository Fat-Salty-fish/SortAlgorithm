package aimToOfferII;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/6
 */
public class AimToOffer48最长不含重复字符的子字符串 {

    /**
     * 看起来就像双指针
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Character> countMap = new HashSet<>();
        while (right < s.length()) {
            while (left <= right && countMap.contains(s.charAt(right))) {
                countMap.remove(s.charAt(left++));
            }
            result = Math.max(result, right - left + 1);
            countMap.add(s.charAt(right));
            right++;
        }
        return result;
    }
}
