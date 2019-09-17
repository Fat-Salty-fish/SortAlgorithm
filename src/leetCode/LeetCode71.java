package leetCode;

import java.util.Stack;

/**
 * @author acer
 * @Date 2019/8/26 22:48
 */
public class LeetCode71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!array[i].isEmpty() && !array[i].equals(".")) {
                stack.push(array[i]);
            }
        }
        String ans = "";
        for (String s : stack) {
            ans += "/" + s;
        }
        return ans.equals("") ? "/" : ans;
    }

    public static void main(String[] args) {
        String a = new LeetCode71().simplifyPath("/../");
    }
}
