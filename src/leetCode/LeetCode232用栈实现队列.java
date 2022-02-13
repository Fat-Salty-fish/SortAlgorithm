package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode232用栈实现队列 {


    class MyQueue {

        /**
         * 第一个队列
         */
        Deque<Integer> firstDeque;

        /**
         * 第二个队列
         */
        Deque<Integer> secondDeque;

        public MyQueue() {
            firstDeque = new ArrayDeque<>();
            secondDeque = new ArrayDeque<>();
        }

        public void push(int x) {
            firstDeque.push(x);
        }

        public int pop() {
            if (!secondDeque.isEmpty()){
                return secondDeque.pop();
            }
            moveFirstToSecond();
            return secondDeque.pop();
        }

        public int peek() {
            if (!secondDeque.isEmpty()){
                return secondDeque.peek();
            }
            moveFirstToSecond();
            return secondDeque.peek();
        }

        public boolean empty() {
            return firstDeque.isEmpty() && secondDeque.isEmpty();
        }

        private void moveFirstToSecond(){
            while (!firstDeque.isEmpty()){
                secondDeque.push(firstDeque.pop());
            }
        }
    }
}
