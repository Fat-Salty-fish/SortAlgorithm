package interviewGuide;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/13
 */
public class InterviewGuide50做项目的最大收益问题 {

    /**
     * 获取做项目的最大收益
     *
     * @param w      初始资金
     * @param k      可以做项目的数量
     * @param cost   每个项目的所需资金
     * @param profit 每个项目的收益
     * @return
     */
    public long getMaxProfit(int w, int k, int[] cost, int[] profit) {
        Project[] projects = new Project[cost.length];
        for (int i = 0; i < cost.length; i++) {
            projects[i] = new Project();
            projects[i].cost = cost[i];
            projects[i].profit = profit[i];
        }

        // 起始资金最小堆
        PriorityQueue<Project> costQueue = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));

        PriorityQueue<Project> profitQueue = new PriorityQueue<>(((o1, o2) -> o2.profit - o1.profit));
        for (Project pj : projects) {
            costQueue.offer(pj);
        }
        int count = 0;
        while (count < k) {
            while (!costQueue.isEmpty() && costQueue.peek().cost <= w) {
                profitQueue.offer(costQueue.poll());
            }
            if (profitQueue.isEmpty()) {
                break;
            }

            Project todo = profitQueue.poll();
            w += todo.profit;
            count++;
        }
        return w;
    }


    /**
     * 项目信息 cost 成本 profit 收益
     */
    class Project {
        public int cost;

        public int profit;
    }

    public static void main(String[] args) {
        int w = 3;
        int k = 2;
        int[] costs = {5, 4, 1, 2};
        int[] profits = {3, 5, 3, 2};
        long result = new InterviewGuide50做项目的最大收益问题().getMaxProfit(w, k, costs, profits);
        System.out.println(result);
    }
}
