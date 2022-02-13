package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static void main(String[] args) {
        int[][] path = {};
        int n = 999;
        int result = new LeetCode1136平行课程().minimumSemesters(n, path);
        System.out.println(result);
    }
}
