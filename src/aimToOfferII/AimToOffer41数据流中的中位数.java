package aimToOfferII;

import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/5
 */
public class AimToOffer41数据流中的中位数 {

    class MedianFinder {

        PriorityQueue<Integer> max;

        PriorityQueue<Integer> min;

        /**
         * initialize your data structure here.
         * 用一个大顶堆和一个小顶堆来实现
         * 堆顶元素表示最中间的那个元素
         */
        public MedianFinder() {
            max = new PriorityQueue<>(((o1, o2) -> o2 - o1));
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (min.isEmpty() && max.isEmpty()) {
                max.offer(num);
                return;
            }
            if (num > max.peek()) {
                min.offer(num);
                if (min.size() - 1 > max.size()) {
                    max.offer(min.poll());
                }
            } else {
                max.offer(num);
                if (max.size() - 1 > min.size()) {
                    min.offer(max.poll());
                }
            }
        }

        public double findMedian() {
            if (min.size() == max.size()) {
                return (1.0 * (min.peek() + max.peek())) / 2;
            } else if (min.size() > max.size()) {
                return min.peek();
            } else {
                return max.peek();
            }
        }
    }
}
