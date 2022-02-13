package aimToOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/25
 */
public class AimToOffer30包含min函数的栈 {

    static class MinStack {

        Deque<Integer> stack;

        Deque<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()){
                minStack.push(x);
            }
        }

        public void pop() {
            int stackPop = stack.pop();
            if (minStack.peek() == stackPop){
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
