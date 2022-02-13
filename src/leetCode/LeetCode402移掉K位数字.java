package leetCode;

import java.util.LinkedList;

/**
 * @author acer
 * @Date 2019/9/2 18:25
 */
public class LeetCode402移掉K位数字 {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        if (k == 0) {
            return num;
        }
        if (num.length() == k) {
            return "0";
        }
        int finalLength = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            Character character = num.charAt(i);
            while (!stack.isEmpty() && character < stack.peekFirst() && k > 0) {
                stack.poll();
                k--;
            }
            stack.push(character);
        }
        while (!stack.isEmpty() && stack.getLast() == '0') {
            stack.pollLast();
        }
        if (stack.isEmpty()) {
            return "0";
        } else {
            StringBuilder builder = new StringBuilder();
            int length = finalLength > stack.size() ? stack.size() : finalLength;
            while (!stack.isEmpty() && finalLength > 0) {
                builder.append(stack.pollLast());
                finalLength--;
            }
            return builder.toString();
        }
    }

    public String removeKdigits2(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode402移掉K位数字().removeKdigits("1173", 2));
    }
}
