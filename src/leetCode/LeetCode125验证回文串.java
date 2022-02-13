package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode125验证回文串 {

    public boolean isPalindrome(String s) {
        List<Character> toNormalList = new ArrayList<>();
        for (Character currentChar : s.toCharArray()) {
            if ((currentChar <= 'z' && currentChar >= 'a') || (currentChar <= '9' && currentChar >= '0')) {
                toNormalList.add(currentChar);
            } else if (currentChar <= 'Z' && currentChar >= 'A') {
                toNormalList.add(Character.toLowerCase(currentChar));
            }
        }
        int left = 0;
        int right = toNormalList.size() - 1;
        while (left <= right) {
            if (!toNormalList.get(left).equals(toNormalList.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "OP";
        boolean result = new LeetCode125验证回文串().isPalindrome(a);
    }
}
