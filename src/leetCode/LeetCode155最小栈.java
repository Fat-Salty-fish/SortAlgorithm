package leetCode;


import java.util.Arrays;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/7/7 17:26
 */
public class LeetCode155最小栈 {
    /**
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     * 示例:
     * <p>
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */
    public static class MinStack {
        public Stack<Integer> myStack;
        public Stack<Integer> minStack;

        public MinStack() {
            myStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if(minStack.size() == 0 || x <= minStack.peek()){
                minStack.push(x);
            }
            myStack.push(x);
        }

        public void pop() {
            if (myStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            myStack.pop();
        }

        public int top() {
            return myStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
