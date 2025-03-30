package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/12
 */
public class LeetCode1136平行课程 {

    class Node {

        public int in;

        public int out;

        public int val;

        public List<Integer> paths;

        public Node(int _val) {
            in = 0;
            out = 0;
            val = _val;
            paths = new ArrayList<>();
        }

        public void addIn() {
            in++;
        }

        public void addOut() {
            out++;
        }

        public void minusIn() {
            in--;
        }

        public void minusOut() {
            out--;
        }

    }

    /**
     * 感觉是bfs或者是图-拓扑排序？
     * 应该就是拓扑排序了
     * 努力回忆一下...
     *
     * @param n
     * @param relations
     * @return
     */
    public int minimumSemesters(int n, int[][] relations) {
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < relations.length; i++) {
            Node from = nodes[relations[i][0]];
            Node to = nodes[relations[i][1]];
            from.paths.add(relations[i][1]);
            from.addOut();
            to.addIn();
        }
        Queue<Node> nodeDeque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (nodes[i].in == 0) {
                nodeDeque.offer(nodes[i]);
            }
        }
        if (nodeDeque.isEmpty()) {
            return -1;
        }
        int depth = 0;
        int nodeSize = n;
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            for (int i = 0; i < size; i++) {
                Node temp = nodeDeque.poll();
                for (int j = 0; j < temp.paths.size(); j++) {
                    int targetNodeIndex = temp.paths.get(j);
                    Node targetNode = nodes[targetNodeIndex];
                    targetNode.minusIn();
                    if (targetNode.in == 0) {
                        nodeDeque.offer(targetNode);
                    }
                }
                nodeSize--;
            }
            depth++;
        }
        return nodeSize == 0 ? depth : -1;
    }

    /**
     * 拓扑排序，并且要BFS
     * 拓扑排序依赖于邻接表，以及记录每个点的入度
     * 如果入度为0，则说明这个点是一个入口（没有依赖项）
     * 删除一条有向边，则等价于这个点的入度减一
     *
     * @param n
     * @param relations
     * @return
     */
    public int minimumSemesters2(int n, int[][] relations) {
        // 构建邻接表，以及入度数组
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        int[] inDegrees = new int[n + 1];
        for (int[] relation : relations) {
            int left = relation[0];
            int right = relation[1];
            var temp = map.getOrDefault(left, new HashSet<>());
            temp.add(right);
            map.put(left, temp);
            inDegrees[right]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // BFS
        for (int inDegree = 1; inDegree <= n; inDegree++) {
            if (inDegrees[inDegree] == 0) {
                queue.offer(inDegree);
            }
        }

        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                int tempNode = queue.poll();
                Set<Integer> targetNodes = map.get(tempNode);
                for (Integer target : targetNodes) {
                    inDegrees[target]--;
                    if (inDegrees[target] == 0) {
                        queue.offer(target);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] != 0) {
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] path = {{1, 2}, {2, 3}, {3, 4}, {4, 2}};
        int n = 4;
        int result = new LeetCode1136平行课程().minimumSemesters2(n, path);
        System.out.println(result);
    }
}
