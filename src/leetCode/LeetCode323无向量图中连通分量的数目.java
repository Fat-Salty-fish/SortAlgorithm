package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode323无向量图中连通分量的数目 {

    /**
     * 广度优先遍历
     * 需要先构建邻接矩阵
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        if (n == 0) {
            return 0;
        }
        // 构建邻接矩阵以及初始化
        ArrayList<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        // 记录访问过的点
        boolean[] visited = new boolean[n];
        // 遍历邻接矩阵，记录结果
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += bfs(i, map, visited);
        }
        return result;
    }

    /**
     * 广度优先遍历邻接矩阵
     * @param node
     * @param edges
     * @param visited
     * @return
     */
    public int bfs(int node, ArrayList<Integer>[] edges, boolean[] visited) {
        if (visited[node]){
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int j = 0; j < edges[temp].size(); j++) {
                    if (!visited[edges[temp].get(j)]){
                        queue.add(edges[temp].get(j));
                        visited[edges[temp].get(j)] = true;
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        int result = new LeetCode323无向量图中连通分量的数目().countComponents(n, edges);
        System.out.println(result);
    }
}
