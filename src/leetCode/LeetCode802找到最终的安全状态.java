package leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode802找到最终的安全状态 {

    /**
     * 拓扑排序
     * 先找到终端节点
     * 如果从一个节点出发的所有出边都指向一个终端节点，那么这个节点就是安全节点
     * graph 已经是一个邻接表了
     * 需要反向拓扑排序
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        Map<Integer, Set<Integer>> matrix = new HashMap<>();
        int[] inDegrees = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int to = graph[i][j];
                Set<Integer> reverse = matrix.getOrDefault(to, new HashSet<>());
                reverse.add(i);
                matrix.put(to, reverse);
                inDegrees[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
                result.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();
                Set<Integer> targets = matrix.getOrDefault(currentNode, new HashSet<>());
                for (Integer target : targets) {
                    inDegrees[target]--;
                    if (inDegrees[target] == 0) {
                        queue.offer(target);
                        result.add(target);
                    }
                }
            }
        }

        return result.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        List<Integer> result = new LeetCode802找到最终的安全状态().eventualSafeNodes(array);
        System.out.println(result);
    }
}
