package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/2
 */
public class LeetCode438找到字符串中所有字母异位词 {

    /**
     * 滑动窗口
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (Character needChar : p.toCharArray()) {
            need.put(needChar, need.getOrDefault(needChar, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int targetLength = p.length();
        while (right < s.length()) {
            Character currentRightChar = s.charAt(right);
            right++;
            if (need.containsKey(currentRightChar)) {
                windows.put(currentRightChar, windows.getOrDefault(currentRightChar, 0) + 1);
                if (need.get(currentRightChar).equals(windows.get(currentRightChar))) {
                    valid++;
                }
            }
            while (right - left >= targetLength) {
                if (valid == need.size()) {
                    result.add(left);
                }
                Character currentLeftChar = s.charAt(left);
                left++;
                if (need.containsKey(currentLeftChar)) {
                    if (need.get(currentLeftChar).equals(windows.get(currentLeftChar))) {
                        valid--;
                    }
                    windows.put(currentLeftChar, windows.get(currentLeftChar) - 1);
                }
            }
        }
        return result;
    }
}
