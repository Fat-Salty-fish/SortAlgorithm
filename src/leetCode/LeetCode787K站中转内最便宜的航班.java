package leetCode;

import java.util.*;

public class LeetCode787K站中转内最便宜的航班 {


    /**
     * BFS? DFS? 图论，总之得构建邻接表和邻接矩阵
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Destination>> map = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            List<Destination> current = map.getOrDefault(from, new ArrayList<>());
            current.add(new Destination(to, cost));
            map.put(from, current);
        }
        // 不能用BFS，需要DFS
        List<Integer> results = new ArrayList<>();
        dfs(map, src, dst, 0, k + 1, results, new HashSet<>(), 0);
        int min = Integer.MAX_VALUE;
        for (int i : results) {
            min = Math.min(min, i);
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public void dfs(Map<Integer, List<Destination>> map, int current, int dst, int currentStep, int k, List<Integer> possibleResult, Set<Integer> passed, int currentCost) {
        if (current == dst && currentStep <= k) {
            possibleResult.add(currentCost);
            return;
        }
        if (current == k) {
            // 不能再往下了
            return;
        }
        List<Destination> nextTargets = map.getOrDefault(current, new ArrayList<>());
        for (Destination destination : nextTargets) {
            int target = destination.target;
            int cost = destination.cost;
            if (!passed.contains(target)) {
                passed.add(target);
                dfs(map, target, dst, currentStep + 1, k, possibleResult, passed, currentCost + cost);
                passed.remove(target);
            }
        }
    }

    /**
     * Dijkstra 算法？
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Destination>> map = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            List<Destination> current = map.getOrDefault(from, new ArrayList<>());
            current.add(new Destination(to, cost));
            map.put(from, current);
        }

        Deque<Pair> deque = new LinkedList<>();
        deque.offer(new Pair(src, 0, 0));
        Map<Integer, Integer> allLatestDistances = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == src) {
                allLatestDistances.put(i, 0);
            } else {
                allLatestDistances.put(i, Integer.MAX_VALUE);
            }
        }
        // BFS
        int step = 0;
        while (!deque.isEmpty()) {
            if (step > k) {
                break;
            }
            int length = deque.size();
            for (int i = 0; i < length; i++) {
                Pair current = deque.poll();
                if (current.current == dst) {
                    continue;
                }
                List<Destination> nexts = map.getOrDefault(current.current, new ArrayList<>());
                for (Destination destination : nexts) {
                    int target = destination.target;
                    int cost = destination.cost;
                    allLatestDistances.put(target, Math.min(allLatestDistances.get(target), allLatestDistances.get(current.current) + cost));
                    deque.offer(new Pair(target, current.cost + cost, current.step + 1));
                }
            }
            step++;
        }
        if (allLatestDistances.get(dst) == Integer.MAX_VALUE) return -1;
        return allLatestDistances.get(dst);
    }

    public static class Pair {
        public int current;

        public int cost;

        public int step;

        public Pair(int current, int cost, int step) {
            this.current = current;
            this.cost = cost;
            this.step = step;
        }
    }


    public static class Destination {
        public int target;

        public int cost;

        public Destination(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }

    /**
     * 动态规划？
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Destination>> toMap = new HashMap<>();
        Map<Integer, List<Destination>> fromMap = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            List<Destination> currentTo = toMap.getOrDefault(from, new ArrayList<>());
            currentTo.add(new Destination(to, cost));
            toMap.put(from, currentTo);

            List<Destination> currentFrom = fromMap.getOrDefault(to, new ArrayList<>());
            currentFrom.add(new Destination(from, cost));
            fromMap.put(to, currentFrom);
        }
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[src][0] = 0;
        // 如何构造dp函数？
        List<Destination> reachable = toMap.get(src);
        for (Destination destination : reachable) {
            dp[destination.target][0] = destination.cost;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                List<Destination> pathToThisPoint = fromMap.getOrDefault(j, new ArrayList<>());
                for (Destination destination : pathToThisPoint) {
                    int from = destination.target;
                    int cost = destination.cost;
                    if (dp[from][i - 1] != Integer.MAX_VALUE) {
                        dp[j][i] = Math.min(dp[j][i], dp[from][i - 1] + cost);
                    }
                }
                dp[j][i] = Math.min(dp[j][i], dp[j][i - 1]);
            }
        }

        return dp[src][k] == Integer.MAX_VALUE ? -1 : dp[src][k];
    }

    public static int MAX = 1000001;

    /**
     * 贝尔曼福特算法
     * 无论如何，一开始一定需要构建邻接矩阵
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice4(int n, int[][] flights, int src, int dst, int k) {
        // 构建邻接矩阵 注意，这里是记录这条边，而不是记录从源点到这个点的最短路径
        // 不需要构建邻接矩阵
        Map<Integer, List<Destination>> map = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            List<Destination> current = map.getOrDefault(from, new ArrayList<>());
            current.add(new Destination(to, cost));
            map.put(from, current);
        }
        // dp 数组，用来记录第i步，到第j个点的最短路径
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i <= k + 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = MAX;
            }
        }
        // 这里不能用Queue/BFS，否则会变成必须在K步内
        dp[0][src] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int j = 0; j < flights.length; j++) {
                int[] path = flights[j];
                int from = path[0];
                int to = path[1];
                int cost = path[2];
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + cost);
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][to]);
            }
        }
        if (dp[k + 1][dst] == MAX) return -1;
        return dp[k + 1][dst];
    }


    public static void main(String[] args) {
        int result = new LeetCode787K站中转内最便宜的航班().findCheapestPrice4(10, new int[][]{{0, 1, 20}, {1, 2, 20}, {2, 3, 30}, {3, 4, 30}, {4, 5, 30}, {5, 6, 30}, {6, 7, 30}, {7, 8, 30}, {8, 9, 30}, {0, 2, 9999}, {2, 4, 9998}, {4, 7, 9997}}, 0, 9, 4);
        System.out.println(result);
    }
}
