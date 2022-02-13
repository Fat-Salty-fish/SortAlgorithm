package codingInterview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/24
 */
public class CodingInterview0305栈排序 {

    static class SortedStack {

        Deque<Integer> stack;


        public SortedStack() {
            stack = new ArrayDeque<>();
        }

        public void push(int val) {
            Deque<Integer> help = new ArrayDeque<>();
            if (isEmpty()) {
                stack.push(val);
                return;
            }
            while (!stack.isEmpty() && stack.peek() <= val) {
                help.push(stack.pop());
            }
            stack.push(val);
            while (!help.isEmpty()) {
                stack.push(help.pop());
            }
        }

        public void pop() {
            if (isEmpty()) {
                return;
            }
            stack.pop();
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.pop();
        stack.pop();
        stack.push(1);
        stack.pop();
        stack.isEmpty();
        System.out.println(stack.peek());
    }
}
