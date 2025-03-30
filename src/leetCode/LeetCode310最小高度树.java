package leetCode;

import java.util.*;

public class LeetCode310最小高度树 {

    /**
     * 拓扑排序
     * 最简单的，遍历每个节点，得到树的高度
     * 但是会超时
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0){
            return new ArrayList<>();
        }
        if (n == 1){
            return List.of(0);
        }

        Map<Integer, Set<Integer>> matrix = new HashMap<>();
        for (int i = 0; i < n; i++) {
            matrix.put(i, new HashSet<>());
        }

        // 用一个array来维护这些节点相关的边的条数
        int[] edgeNum = new int[n];
        // 保存度
        for (int[] edge : edges) {
            int source = edge[0];
            int target = edge[1];
            edgeNum[source]++;
            edgeNum[target]++;
            matrix.get(source).add(target);
            matrix.get(target).add(source);
        }
        List<Integer> result = new ArrayList<>();

        // 拓扑排序，逐渐删除度为1的节点，从而找到整棵树里位于中间的那个节点
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (edgeNum[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            result = new ArrayList<>(queue);
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                Set<Integer> related = matrix.get(current);
                for (Integer target : related) {
                    edgeNum[target] --;
                    if (edgeNum[target] == 1) {
                        queue.offer(target);
                    }
                    matrix.get(target).remove(current);
                }
            }
        }

        return result;
    }
}
