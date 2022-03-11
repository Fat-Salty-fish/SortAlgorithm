package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * 二刷
     * 用dfs来解决括号问题
     *
     * @param s
     * @return
     */
    public int calculate2(String s) {
        s = s.replaceAll(" ","");
        return dfs(s, 0)[0];
    }

    /**
     * @param string
     * @return 返回数组array 长度一定为2 array[0]表示这次计算的结果，array[1]表示这次计算到哪一位
     */
    public int[] dfs(String string, int startIndex) {
        int[] result = new int[2];
        LinkedList<String> queue = new LinkedList<>();
        int currentIndex = startIndex;
        int currentNum = 0;
        while (currentIndex < string.length() && string.charAt(currentIndex) != ')') {
            if (string.charAt(currentIndex) >= '0' && string.charAt(currentIndex) <= '9') {
                currentNum = currentNum * 10 + string.charAt(currentIndex++) - '0';
            } else if (string.charAt(currentIndex) != '(') {
                addNum(queue, currentNum);
                queue.addLast(String.valueOf(string.charAt(currentIndex++)));
                currentNum = 0;
            } else {
                int[] tempResult = dfs(string, currentIndex + 1);
                currentNum = tempResult[0];
                currentIndex = tempResult[1] + 1;
            }
        }
        addNum(queue, currentNum);
        result[0] = getNum(queue);
        result[1] = currentIndex;
        return result;
    }

    /**
     * 向queue中添加数字 queue中既包含了数字也包含了运算符号
     *
     * @param queue
     * @param num
     */
    public void addNum(LinkedList<String> queue, int num) {
        if (!queue.isEmpty()) {
            String top = queue.pollLast();
            if ("+".equals(top) || "-".equals(top)) {
                queue.addLast(top);
            } else {
                int pre = Integer.parseInt(queue.pollLast());
                num = "*".equals(queue.pollLast()) ? pre * num : pre / num;
            }
        }
        queue.addLast(String.valueOf(num));
    }

    /**
     * 计算结果
     *
     * @param formula
     * @return
     */
    public int getNum(LinkedList<String> formula) {
        int result = 0;
        boolean add = true;
        String current = null;
        int num = 0;
        while (!formula.isEmpty()) {
            current = formula.pollFirst();
            if ("+".equals(current)) {
                add = true;
            } else if ("-".equals(current)) {
                add = false;
            } else {
                num = Integer.valueOf(current);
                result += add ? num : (-num);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String str = "2-1 + 2 ";
        int result = new LeetCode224基本计算器().calculate2(str);
        System.out.println(result);
    }
}
