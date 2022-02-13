package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/3 9:37
 */
public class LeetCode150逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String a = tokens[i];
            //是各种符号 就弹出两个数字进行计算并将数字再压入栈中
            if ("+".equals(a)) {
                Integer num1 = number.pop();
                Integer num2 = number.pop();
                num2 += num1;
                number.push(num2);
            } else if ("-".equals(a)) {
                Integer num1 = number.pop();
                Integer num2 = number.pop();
                num2 -= num1;
                number.push(num2);
            } else if ("/".equals(a)) {
                Integer num1 = number.pop();
                Integer num2 = number.pop();
                num2 /= num1;
                number.push(num2);
            } else if ("*".equals(a)) {
                Integer num1 = number.pop();
                Integer num2 = number.pop();
                num2 *= num1;
                number.push(num2);
                //这个字符串是数字
            } else {
                Integer temp = Integer.valueOf(a);
                number.push(temp);
            }
        }
        return number.pop();
    }


    public int evalRPN2(String[] tokens) {
        Deque<Integer> numDeque = new ArrayDeque<>();
        for (String temp : tokens) {
            if ("*".equals(temp)) {
                Integer secondNum = numDeque.pop();
                Integer firstNum = numDeque.pop();
                numDeque.push(firstNum * secondNum);
            } else if ("/".equals(temp)) {
                Integer secondNum = numDeque.pop();
                Integer firstNum = numDeque.pop();
                numDeque.push(firstNum / secondNum);
            } else if ("-".equals(temp)) {
                Integer secondNum = numDeque.pop();
                Integer firstNum = numDeque.pop();
                numDeque.push(firstNum - secondNum);
            } else if ("+".equals(temp)) {
                Integer secondNum = numDeque.pop();
                Integer firstNum = numDeque.pop();
                numDeque.push(firstNum + secondNum);
            } else {
                numDeque.push(Integer.valueOf(temp));
            }
        }
        return numDeque.peek();
    }
}
