package leetCode;

import java.util.Stack;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/31
 */
public class LeetCode394字符串解码 {

    StringBuilder result = new StringBuilder();

    Stack<Integer> numStack = new Stack<>();

    Stack<String> strStack = new Stack<>();

    public String decodeString(String s) {
        int index = 0;
        while (index < s.length()) {
            Character currentChar = s.charAt(index);
            if (currentChar >= '0' && currentChar <= '9') {
                int tempNum = 0;
                while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    tempNum = 10 * tempNum + (s.charAt(index) - '0');
                    index++;
                }
                numStack.push(tempNum);
            } else if (currentChar == ']') {
                StringBuilder builder = new StringBuilder();
                while (!strStack.isEmpty() && !"[".equals(strStack.peek())) {
                    builder.insert(0, strStack.pop());
                }
                String tempStr = builder.toString();
                int times = numStack.pop();
                for (int i = 0; i < times - 1; i++) {
                    builder.append(tempStr);
                }
                strStack.pop();
                strStack.push(builder.toString());
                index++;
            } else {
                strStack.push(String.valueOf(currentChar));
                index++;
            }
        }
        while (!strStack.isEmpty()) {
            result.insert(0, strStack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String result = new LeetCode394字符串解码().decodeString(s);
        System.out.println(result);
    }
}
