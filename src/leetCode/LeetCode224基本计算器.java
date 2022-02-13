package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/3
 */
public class LeetCode224基本计算器 {

    /**
     * 用栈解决 基本计算器
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 符号栈
        Deque<Character> symbolDeque = new ArrayDeque<>();

        // 数字栈
        Deque<Integer> numDeque = new ArrayDeque<>();
        numDeque.offer(0);
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                index++;
                continue;
            } else if (s.charAt(index) == '(') {
                symbolDeque.push(s.charAt(index));
            } else if (s.charAt(index) == ')') {
                // 不断从symbol弹出来一个符号 从numDeque里弹出两个数字 直到symbol弹出来的不是左括号
                while (!symbolDeque.isEmpty() && symbolDeque.peek() != '(') {
                    // 计算
                    Character symbol = symbolDeque.poll();
                    calculate(numDeque, symbol);
                }
                // 需要将左括号弹出
                symbolDeque.poll();
            } else if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                if (index > 0 && (s.charAt(index - 1) == '(')) {
                    numDeque.push(0);
                }
                // 把之前的数字都先计算一遍
                while (!symbolDeque.isEmpty() && symbolDeque.peek() != '(') {
                    // 计算
                    Character symbol = symbolDeque.poll();
                    calculate(numDeque, symbol);
                }
                symbolDeque.push(s.charAt(index));
            } else {
                // 计算数字 并且插入进去
                int currentNum = 0;
                while (index < s.length() && s.charAt(index) <= '9' && s.charAt(index) >= '0') {
                    currentNum = 10 * currentNum + (s.charAt(index) - '0');
                    index++;
                }
                numDeque.push(currentNum);
                continue;
            }
            index++;
        }
        while (!symbolDeque.isEmpty() || numDeque.size() > 1) {
            int secondNum = numDeque.poll();
            int firstNum = numDeque.poll();
            Character currentSymbol = symbolDeque.poll();
            if (currentSymbol == null) {
                currentSymbol = '+';
            }
            if (currentSymbol == '+') {
                numDeque.push(firstNum + secondNum);
            } else {
                numDeque.push(firstNum - secondNum);
            }
        }
        return numDeque.peek();
    }

    /**
     * 计算两个数
     *
     * @param numDeque
     * @param symbol
     */
    public void calculate(Deque<Integer> numDeque, Character symbol) {
        if (numDeque.size() < 2) {
            return;
        }
        int secondNum = numDeque.poll();
        int firstNum = numDeque.poll();
        if (symbol == '+') {
            numDeque.push(firstNum + secondNum);
        } else {
            numDeque.push(firstNum - secondNum);
        }
    }


    public static void main(String[] args) {
        String str = "2-(1+2)";
        int result = new LeetCode224基本计算器().calculate(str);
        System.out.println(result);
    }
}
