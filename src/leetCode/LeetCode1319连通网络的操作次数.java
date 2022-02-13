package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/31
 */
public class LeetCode1319连通网络的操作次数 {

    List<Integer>[] edges;

    boolean[] visited;

    /**
     * 一共有n个节点 要把他们都连接起来 需要有n-1条线缆
     *
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n, int[][] connections) {
        int cablesNum = connections.length;
        // 线缆不足
        if (cablesNum < n - 1) {
            return -1;
        }
        edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            edges[connection[0]].add(connection[1]);
            edges[connection[1]].add(connection[0]);
        }
        visited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }
        return result - 1;
    }

    public void dfs(int currentNode) {
        visited[currentNode] = true;
        List<Integer> neighbors = edges[currentNode];
        for (int i = 0; i < neighbors.size(); i++) {
            if (!visited[neighbors.get(i)]) {
                dfs(neighbors.get(i));
            }
        }
    }
}
