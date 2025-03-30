package leetCode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LeetCode624数组列表中的最大距离 {

    /**
     * 双指针应该就可以解决
     * 两个优先队列即可，一个大顶堆，一个小顶堆
     *
     * @param arrays
     * @return
     */
    public int maxDistance(List<List<Integer>> arrays) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> y - x);
        min.add(arrays.getFirst().getFirst());
        max.add(arrays.getFirst().getLast());
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            int currentMin = arrays.get(i).getFirst();
            int currentMax = arrays.get(i).getLast();
            int minRange = Math.abs(currentMin - max.peek());
            int maxRange = Math.abs(currentMax - min.peek());
            result = Math.max(result, minRange);
            result = Math.max(result, maxRange);
            min.add(currentMin);
            max.add(currentMax);
        }
        return result;
    }
}
