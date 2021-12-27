package leetCode;

import java.util.Stack;

/**
 * @author acer
 * @Date 2019/7/23 18:01
 */
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//
//示例 1:
//
//输入: "()"
//输出: true
//示例 2:
//
//输入: "()[]{}"
//输出: true
//示例 3:
//
//输入: "(]"
//输出: false
//示例 4:
//
//输入: "([)]"
//输出: false
//示例 5:
//
//输入: "{[]}"
//输出: true
public class LeetCode20有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //对每一个字符进行判断
        //整个字符串遍历结束之后应该符号栈中是没有元素的
        //对于每一个字符 如果是左括号则应该添加到栈中
        //对于每一个字符 如果是右括号则应当匹配栈顶的左括号 如果匹配则弹出 否则压入到栈中
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                if (check(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //c为右括号中的一种
    public boolean check(Character left, Character right) {
        return ((left == '{' && right == '}') || (left == '(' && right == ')') || (left == '[' && right == ']'));
    }

    /**
     * 二刷有效的括号
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (current == '(' || current == '{' || current == '['){
                characterStack.push(current);
            }else if (current == ')'){
                if (!characterStack.isEmpty() && characterStack.peek()=='('){
                    characterStack.pop();
                }else {
                    return false;
                }
            }else if (current == '}'){
                if (!characterStack.isEmpty() && characterStack.peek() == '{'){
                    characterStack.pop();
                }else {
                    return false;
                }
            }else if (current == ']'){
                if (!characterStack.isEmpty() && characterStack.peek() == '['){
                    characterStack.pop();
                }else {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode20有效的括号 result = new LeetCode20有效的括号();
        System.out.println(result.isValid("(])"));
    }
}
