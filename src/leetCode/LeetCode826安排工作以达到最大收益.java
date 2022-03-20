package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/13
 */
public class LeetCode826安排工作以达到最大收益 {

    /**
     * 安排工作
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Work[] works = new Work[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            works[i] = new Work();
            works[i].difficulty = difficulty[i];
            works[i].profit = profit[i];
        }
        PriorityQueue<Work> difficultPQ = new PriorityQueue<>((Comparator.comparingInt(o -> o.difficulty)));
        PriorityQueue<Work> profitPQ = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);
        for (Work temp : works) {
            difficultPQ.offer(temp);
        }
        Arrays.sort(worker);
        int index = 0;
        int result = 0;
        while (index < worker.length) {
            while (!difficultPQ.isEmpty() && difficultPQ.peek().difficulty <= worker[index]) {
                profitPQ.offer(difficultPQ.poll());
            }
            if (profitPQ.isEmpty()) {
                index++;
            } else {
                result += profitPQ.peek().profit;
                index++;
            }
        }
        return result;
    }

    class Work {
        public int difficulty;

        public int profit;
    }
}
