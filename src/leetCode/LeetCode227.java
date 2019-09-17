package leetCode;

import javax.swing.plaf.synth.SynthUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/8/29 22:13
 */
public class LeetCode227 {
    public int calculate(String s) {
        int ans = 0;
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length();i++) {
            char ch = s.charAt(i);
            //判断是否为数字
            if (ch >= '0' && ch <= '9') {
                num = num*10 + ch-'0';
            }
            //如果ch为一个符号
            if(i == s.length()-1 || !(ch >= '0' && ch <= '9') && ch != ' '){
                if(op == '+'){
                    numStack.push(num);
                }else if(op == '-'){
                    numStack.push(-num);
                }else if(op == '*'){
                    numStack.push(numStack.pop() * num);
                }else if(op == '/'){
                    numStack.push(numStack.pop() / num);
                }
                op = ch;
                num = 0;
            }
        }
        while (!numStack.isEmpty()){
            ans+= numStack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode227().calculate("3+2*2"));
        LinkedList<Integer> list = new LinkedList();
        list.clear();;
    }
}
