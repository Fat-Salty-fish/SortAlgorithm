package leetCode;

import java.awt.font.NumericShaper;
import java.io.CharConversionException;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/3 9:37
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String a = tokens[i];
            //是各种符号 就弹出两个数字进行计算并将数字再压入栈中
            if("+".equals(a)){
                Integer num1 = number.pop();
                Integer num2 = number.pop();
                num2 += num1;
                number.push(num2);
            }else if("-".equals(a)){
                Integer num1 = number.pop();
                Integer num2 = number.pop();
                num2 -= num1;
                number.push(num2);
            }else if("/".equals(a)){
                Integer num1 = number.pop();
                Integer num2 = number.pop();
                num2 /= num1;
                number.push(num2);
            }else if("*".equals(a)){
                Integer num1 = number.pop();
                Integer num2 = number.pop();
                num2 *= num1;
                number.push(num2);
                //这个字符串是数字
            }else {
                Integer temp = Integer.valueOf(a);
                number.push(temp);
            }
        }
        return number.pop();
    }
}
