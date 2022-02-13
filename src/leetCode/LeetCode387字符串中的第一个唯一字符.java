package leetCode;

import java.util.HashMap;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode387字符串中的第一个唯一字符 {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> nums = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            nums.put(temp, nums.getOrDefault(temp, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (nums.get(temp) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String temp = "leetcode";
        int result = new LeetCode387字符串中的第一个唯一字符().firstUniqChar(temp);
    }
}
