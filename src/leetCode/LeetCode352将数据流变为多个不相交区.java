package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/4
 */
public class LeetCode352将数据流变为多个不相交区 {


    static class SummaryRanges {

        PriorityQueue<Integer> pq;

        public SummaryRanges() {
            pq = new PriorityQueue<>();
        }

        public void addNum(int val) {
            pq.offer(val);
        }

        public int[][] getIntervals() {
            List<Integer> numList = new ArrayList<>();
            PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
            while (!temp.isEmpty()) {
                numList.add(temp.poll());
            }
            List<int[]> resultArray = new ArrayList<>();
            int index = 0;
            while (index < numList.size()) {
                int left = numList.get(index);
                int right = left;
                while (++index < numList.size() && numList.get(index) <= right + 1) {
                    right = numList.get(index);
                }
                resultArray.add(new int[]{left, right});
            }
            return resultArray.toArray(new int[resultArray.size()][]);
        }
    }


    static class SummaryRanges2 {

        TreeSet<int[]> treeSet = new TreeSet<>(((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

        public SummaryRanges2() {

        }

        public void addNum(int val) {
            int[] array = new int[]{val, val};
            if (treeSet.contains(array)) {
                return;
            }
            // last的left最大值为val right的最大值为val
            int[] last = treeSet.lower(array);
            // next的left最小值为val right的最小值为val
            int[] next = treeSet.higher(array);
            if (last != null && last[1] + 1 >= val && next != null && next[0] - 1 <= val) {
                last[1] = next[1];
                treeSet.remove(next);
            } else if (last != null && last[1] + 1 >= val) {
                last[1] = Math.max(last[1], val);
            } else if (next != null && next[0] <= val + 1) {
                next[0] = Math.min(next[0], val);
            } else {
                treeSet.add(array);
            }
        }

        public int[][] getIntervals() {
            int[][] result = new int[treeSet.size()][];
            Iterator<int[]> iterator = treeSet.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                result[index++] = iterator.next();
            }
            return result;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);

        List<Integer> list = new ArrayList<>(queue);
        System.out.println("运行到这里啦");
    }

}
