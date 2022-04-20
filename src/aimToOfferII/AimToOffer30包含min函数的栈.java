package aimToOfferII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/31
 */
public class AimToOffer30包含min函数的栈 {


    class MinStack {

        Deque<Integer> stack;

        Deque<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new ArrayDeque<>();
            min = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            min.push(min.isEmpty() ? x : Math.min(x, min.peek()));
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        public int min() {
            if (min.isEmpty()) {
                return -1;
            }
            return min.peek();
        }
    }
}
