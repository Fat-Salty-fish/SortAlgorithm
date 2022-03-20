package interviewGuide;

import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/13
 */
public class InterviewGuide51分金条的最小花费 {

    /**
     * 分金条的最小花费 先从最小的开始合并即可
     *
     * @param array
     * @return
     */
    public int price(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int temp : array) {
            pq.offer(temp);
        }
        while (pq.size() >= 2) {
            int sum = pq.poll() + pq.poll();
            result += sum;
            pq.offer(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {10, 30, 20};
        System.out.println(new InterviewGuide51分金条的最小花费().price(array));
    }
}
