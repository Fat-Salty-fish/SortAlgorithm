package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/27
 */
public class LeetCode207课程表 {

    /**
     * 无环有向图的边
     */
    List<List<Integer>> edges = new ArrayList<>();

    /**
     * 节点是否被访问过 0 未被访问 1 正在访问中 2 已经访问完成
     */
    int[] visited;

    /**
     * 是否有环 true表示有环 false表示无环
     */
    boolean haveLoop;


    /**
     * 经典 拓扑排序 题目
     * 如果一个图为有环有向图 那么一定没有拓扑排序 因为在拓扑排序中 一条边的两端 必须有一端在另一端的前边
     * 这题与210类似 所以需要遍历一次输入的数组 判断是否能构建一个拓扑排序
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        haveLoop = false;
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int left = prerequisites[i][0];
            int right = prerequisites[i][1];
            List<Integer> edge = edges.get(left);
            edge.add(right);
        }
        // 对于每一个节点 进行dfs
        for (int i = 0; i < edges.size(); i++) {
            if (visited[i] == 0) {
                dfs(i, edges.get(i));
            }
        }
        return !haveLoop;
    }

    public void dfs(int currentNode, List<Integer> edge) {
        if (visited[currentNode] == 1) {
            haveLoop = true;
            return;
        }
        if (visited[currentNode] == 2) {
            return;
        }
        visited[currentNode] = 1;
        for (int current : edge) {
            dfs(current, edges.get(current));
        }
        visited[currentNode] = 2;
    }

    /**
     * 拓扑排序
     * 计算每门课的入度
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> matrix = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            matrix.put(i, new HashSet<>());
        }
        for (int[] edge : prerequisites) {
            int start = edge[0];
            int end = edge[1];
            inDegree.put(end, inDegree.get(end) + 1);
            matrix.get(start).add(end);
        }

        // BFS 即可
        Deque<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        int finishedCourses = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                finishedCourses ++;
                Set<Integer> targets = matrix.get(cur);
                for (Integer target : targets) {
                    inDegree.put(target, inDegree.get(target) - 1);
                    if (inDegree.get(target) == 0){
                        queue.offer(target);
                    }
                }
            }
        }

        return finishedCourses == numCourses;
    }


}
