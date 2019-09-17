package leetCode;

import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/4 23:31
 */
public class LeetCode856括号的分数 {
    public int scoreOfParentheses(String S) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }

    public int deep(String S) {
        int ans = 0;
        int deepth = 0;
        for (int i = 0;i<S.length();i++) {
            if(S.charAt(i) == '('){
                deepth++;
            }else {
                deepth--;
                if(S.charAt(i-1) == '('){
                    ans += 1<<deepth;
                }
            }
        }
        return ans;
    }
}
