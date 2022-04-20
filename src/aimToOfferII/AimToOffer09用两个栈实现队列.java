package aimToOfferII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/26
 */
public class AimToOffer09用两个栈实现队列 {

    class CQueue {

        Deque<Integer> first;

        Deque<Integer> second;

        public CQueue() {
            first = new ArrayDeque<>();
            second = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            first.push(value);
        }

        public int deleteHead() {
            if (!second.isEmpty()) {
                return second.pop();
            } else {
                while (!first.isEmpty()) {
                    second.push(first.pop());
                }
                if (second.isEmpty()) {
                    return -1;
                }
                return second.pop();
            }
        }
    }

}
