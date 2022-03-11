package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author acer
 * @Date 2019/9/2 19:00
 */
public class LeetCode316去除重复字幕 {
    public String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            //获得当前的字符
            Character character = s.charAt(i);
            //如果栈中已经存在这个字符 则直接跳过
            if (stack.contains(character)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekFirst() > character && s.lastIndexOf(stack.peek()) > i) {
                stack.pop();
            }
            stack.push(character);
        }
        StringBuilder builder = new StringBuilder("");
        while (!stack.isEmpty()) {
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }

    /**
     * 二刷 程序员面试指南方法
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters2(String s) {
        Map<Character, Integer> countMap = getCharCountMap(s);
        int index = 0;
        StringBuilder builder = new StringBuilder();
        int minIndex = -1;
        while (index < s.length()) {
            Character temp = s.charAt(index);
            countMap.put(temp, countMap.get(temp) - 1);
            minIndex = minIndex == -1 ? index : (s.charAt(index) < s.charAt(minIndex) ? index : minIndex);
            if (countMap.get(temp) != 0) {
                index++;
                continue;
            }
            Character addChar = s.charAt(minIndex);
            builder.append(addChar);
            index = minIndex + 1;
            s = s.substring(index);
            s = removeChar(s, addChar);
            index = 0;
            minIndex = -1;
            countMap = getCharCountMap(s);
        }
        return builder.toString();
    }

    /**
     * 将字符串记数
     *
     * @param s
     * @return
     */
    public Map<Character, Integer> getCharCountMap(String s) {
        if (s == null || s.isEmpty()) {
            return new HashMap<>();
        }
        Map<Character, Integer> result = new HashMap<>();
        for (Character temp : s.toCharArray()) {
            result.put(temp, result.getOrDefault(temp, 0) + 1);
        }
        return result;
    }

    /**
     * 从s中删除字符
     *
     * @param s
     * @param removeChar
     * @return
     */
    public String removeChar(String s, Character removeChar) {
        StringBuilder builder = new StringBuilder();
        for (Character temp : s.toCharArray()) {
            if (!removeChar.equals(temp)) {
                builder.append(temp);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode316去除重复字幕().removeDuplicateLetters2("bcabc"));
    }
}
