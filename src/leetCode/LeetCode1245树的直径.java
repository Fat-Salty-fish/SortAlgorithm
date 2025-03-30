package leetCode;

import java.util.*;

public class LeetCode1245树的直径 {

    /**
     * 拓扑排序
     * 从外面开始删除节点
     * 删除度为1的节点
     *
     * @param edges
     * @return
     */
    public int treeDiameter(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return 0;
        }
        if (edges.length == 1) {
            return 1;
        }
        Map<Integer, Integer> degrees = new HashMap<>();
        Map<Integer, Set<Integer>> matrix = new HashMap<>();
        for (int[] pair : edges) {
            int from = pair[0];
            int to = pair[1];
            degrees.put(from, degrees.getOrDefault(from, 0) + 1);
            degrees.put(to, degrees.getOrDefault(to, 0) + 1);
            Set<Integer> relatedToFrom = matrix.getOrDefault(from, new HashSet<>());
            relatedToFrom.add(to);
            matrix.put(from, relatedToFrom);
            Set<Integer> relatedToTo = matrix.getOrDefault(to, new HashSet<>());
            relatedToTo.add(from);
            matrix.put(to, relatedToTo);
        }
        int nodes = degrees.keySet().size();
        int visited = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : degrees.entrySet()) {
            if (entry.getValue() == 1) {
                queue.offer(entry.getKey());
            }
        }
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size == 1) {
                return steps * 2;
            }
            if (size == 2 && visited + 2 == nodes) {
                return steps * 2 + 1;
            }
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                visited++;
                Set<Integer> relatedToCurrent = matrix.get(current);
                for (Integer related : relatedToCurrent) {
                    degrees.put(related, degrees.get(related) - 1);
                    if (degrees.get(related) == 1) {
                        queue.offer(related);
                    }
                    matrix.get(related).remove(current);
                }

            }
            steps++;
        }

        return steps * 2;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}};
        int result = new LeetCode1245树的直径().treeDiameter(edges);
        System.out.println(result);
    }
}
