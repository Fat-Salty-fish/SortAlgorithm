package leetCode;

import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/2
 */
public class LeetCode295数据流的中位数 {

    static class MedianFinder {

        /**
         * 最大堆
         */
        PriorityQueue<Integer> max;

        /**
         * 最小堆
         */
        PriorityQueue<Integer> min;

        /**
         * 两个堆 一个最大堆 一个最小堆
         * 两个堆的size差距不能超过1
         * 两个堆的堆顶元素即可判断中位数
         */
        public MedianFinder() {
            // 升序是小顶堆
            min = new PriorityQueue<>(((o1, o2) -> o1 - o2));
            // 降序是大顶堆
            max = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        }

        /**
         * 向两个堆中添加元素
         * 如果元素总数量为奇数 则min多一个
         * 如果元素总数量为偶数 则两个堆元素数量相同
         *
         * @param num
         */
        public void addNum(int num) {
            if (max.isEmpty() && (max.size() == min.size())) {
                max.offer(num);
                return;
            }
            if (num <= max.peek()) {
                max.offer(num);
                if (max.size() - 1 > min.size()) {
                    min.offer(max.peek());
                    max.poll();
                }
            } else {
                min.offer(num);
                if (min.size() - 1 > max.size()) {
                    max.offer(min.peek());
                    min.poll();
                }
            }
        }

        /**
         * 根据两个堆的数量即可判断
         *
         * @return
         */
        public double findMedian() {
            if (min.size() == max.size() && !min.isEmpty()) {
                return 1.0 * (max.peek() + min.peek()) / 2;
            }
            if (min.size() < max.size()) {
                return max.peek();
            }
            if (min.size() > max.size()) {
                return min.peek();
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

}
