package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/19
 */
public class LeetCode870优势洗牌 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        NumAndIndex[] nums2Pairs = new NumAndIndex[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            NumAndIndex temp = new NumAndIndex();
            temp.num = nums2[i];
            temp.index = i;
            nums2Pairs[i] = temp;
        }
        Arrays.sort(nums2Pairs, (Comparator.comparingInt(o -> o.num)));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rubbish = new PriorityQueue<>();
        for (int temp : nums1) {
            pq.offer(temp);
        }
        for (NumAndIndex temp : nums2Pairs) {
            while (!pq.isEmpty() && pq.peek() <= temp.num) {
                rubbish.offer(pq.poll());
            }
            if (!pq.isEmpty()) {
                result[temp.index] = pq.poll();
            } else {
                result[temp.index] = rubbish.poll();
            }
        }
        return result;
    }

    /**
     * 存放数组2的数值和位置index
     */
    class NumAndIndex {
        public int num;
        public int index;
    }
}
