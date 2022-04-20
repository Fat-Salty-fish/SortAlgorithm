package aimToOfferII;

import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/5
 */
public class AimToOffer40最小的K个数 {


    /**
     * 大顶堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int temp : arr) {
            pq.offer(temp);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
        return result;
    }
}
