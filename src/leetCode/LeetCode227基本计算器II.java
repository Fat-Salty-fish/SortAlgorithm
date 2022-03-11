package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/8/29 22:13
 */
public class LeetCode227基本计算器II {
    public int calculate(String s) {
        int ans = 0;
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //判断是否为数字
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            }
            //如果ch为一个符号
            if (i == s.length() - 1 || !(ch >= '0' && ch <= '9') && ch != ' ') {
                if (op == '+') {
                    numStack.push(num);
                } else if (op == '-') {
                    numStack.push(-num);
                } else if (op == '*') {
                    numStack.push(numStack.pop() * num);
                } else if (op == '/') {
                    numStack.push(numStack.pop() / num);
                }
                op = ch;
                num = 0;
            }
        }
        while (!numStack.isEmpty()) {
            ans += numStack.pop();
        }
        return ans;
    }

    /**
     * 二刷
     *
     * @param s
     * @return
     */
    public int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> symbolStack = new ArrayDeque<>();
        int result = 0;
        int index = 0;
        char[] charArray = s.toCharArray();
        while (index < s.length()) {
            if (charArray[index] == ' ') {
                index++;
                continue;
            }
            if (charArray[index] == '+' || charArray[index] == '-') {
                // 先把已经有的符号计算一次
                while (!symbolStack.isEmpty()) {
                    calculate(numStack, symbolStack);
                }
                symbolStack.push(charArray[index]);
                index++;
            } else if (charArray[index] == '*' || charArray[index] == '/') {
                symbolStack.push(charArray[index]);
                index++;
            } else {
                int num = 0;
                while (index < s.length() && charArray[index] <= '9' && charArray[index] >= '0') {
                    num = 10 * num + (charArray[index] - '0');
                    index++;
                }
                numStack.push(num);
                while (!symbolStack.isEmpty() && (symbolStack.peek() == '*' || symbolStack.peek() == '/')) {
                    int secondNum = numStack.pop();
                    int firstNum = numStack.pop();
                    Character currentSymbol = symbolStack.pop();
                    if (currentSymbol == '*') {
                        numStack.push(firstNum * secondNum);
                    } else {
                        numStack.push(firstNum / secondNum);
                    }
                }
            }
        }

        while (!symbolStack.isEmpty()) {
            int secondNum = numStack.pop();
            int firstNum = numStack.pop();
            Character symbol = symbolStack.pop();
            if (symbol == '+') {
                numStack.push(firstNum + secondNum);
            } else {
                numStack.push(firstNum - secondNum);
            }
        }
        return numStack.peek();
    }

    /**
     * 计算
     *
     * @param numStack
     * @param symbolStack
     */
    public void calculate(Deque<Integer> numStack, Deque<Character> symbolStack) {
        if (numStack.size() < 2) {
            return;
        }
        int secondNum = numStack.pop();
        int firstNum = numStack.pop();
        char symbol = symbolStack.pop();
        if (symbol == '+') {
            numStack.push(firstNum + secondNum);
        } else {
            numStack.push(firstNum - secondNum);
        }
    }

    /**
     * 三刷
     *
     * @param s
     * @return
     */
    public int calculate3(String s) {
        s = s.replaceAll(" ", "");
        int index = 0;
        int pre = 0;
        LinkedList<String> formula = new LinkedList<>();
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                pre = pre * 10 + s.charAt(index++) - '0';
            } else {
                addNum(formula, pre);
                formula.addLast(String.valueOf(s.charAt(index++)));
                pre = 0;
            }
        }
        addNum(formula, pre);
        return getResult(formula);
    }

    /**
     * 向方程里添加数字
     *
     * @param formula
     * @param num
     */
    public void addNum(LinkedList<String> formula, int num) {
        if (!formula.isEmpty()) {
            String symbol = formula.pollLast();
            if ("+".equals(symbol) || "-".equals(symbol)) {
                formula.addLast(symbol);
            } else {
                int pre = Integer.parseInt(formula.pollLast());
                num = "*".equals(symbol) ? pre * num : pre / num;
            }
        }
        formula.addLast(String.valueOf(num));
    }

    /**
     * 将方程式转换为结果
     *
     * @param formula
     * @return
     */
    public int getResult(LinkedList<String> formula) {
        int result = 0;
        boolean plus = true;
        while (!formula.isEmpty()) {
            String poll = formula.pollFirst();
            if ("+".equals(poll)) {
                plus = true;
            } else if ("-".equals(poll)) {
                plus = false;
            } else {
                int num = Integer.parseInt(poll);
                result += plus ? num : (-num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode227基本计算器II().calculate2("3+2*2"));
        LinkedList<Integer> list = new LinkedList();
        list.clear();
    }
}
