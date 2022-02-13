package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/13
 */
public class LeetCode301删除无效的括号 {

    int maxLength;

    Set<String> resultSet = new HashSet<>();

    /**
     * 腾讯模拟面试
     * dfs
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        int length = s.length();
        for (char temp : s.toCharArray()) {
            if (temp == '(') {
                left++;
            } else if (temp == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        maxLength = length - left - right;
        dfs("", 0, 0, s, 0);
        return new ArrayList<>(resultSet);
    }

    /**
     * dfs 构造结果
     *
     * @param currentPath
     * @param left
     * @param right
     */
    public void dfs(String currentPath, int left, int right, String originalS, int currentIndex) {
        if (right > left) {
            return;
        }
        if (currentIndex == originalS.length()) {
            if (left == right && currentPath.length() == maxLength) {
                resultSet.add(currentPath);
            }
            return;
        }
        char currentChar = originalS.charAt(currentIndex);
        if (currentChar == '(') {
            dfs(currentPath + "(", left + 1, right, originalS, currentIndex + 1);
            dfs(currentPath, left, right, originalS, currentIndex + 1);
        } else if (currentChar == ')') {
            dfs(currentPath + ")", left, right + 1, originalS, currentIndex + 1);
            dfs(currentPath, left, right, originalS, currentIndex + 1);
        } else {
            dfs(currentPath + currentChar, left, right, originalS, currentIndex + 1);
        }
    }
}
