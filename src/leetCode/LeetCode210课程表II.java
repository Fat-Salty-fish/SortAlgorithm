package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/3
 */
public class LeetCode210课程表II {

    /**
     * 用数组来表示栈
     */
    public int[] stack;

    /**
     * 栈顶元素位置索引
     */
    public int indexOfLast;

    /**
     * 边 有向边
     */
    public List<List<Integer>> edges;

    /**
     * 图内是否有环
     */
    public boolean haveLoop;

    /**
     * 节点是否被访问过
     * 0表示未被访问过 1表示正在被访问 2表示已经访问过了
     */
    public int[] visited;

    /**
     * 拓扑排序 dfs
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        stack = new int[numCourses];
        haveLoop = false;
        indexOfLast = 0;
        visited = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[0];
            int target = edge[1];
            edges.get(from).add(target);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        // 如果有环 则不能实现
        if (haveLoop) {
            return new int[]{};
        }
        return stack;
    }

    /**
     * 遍历当前节点
     *
     * @param currentNode
     */
    public void dfs(int currentNode) {
        if (visited[currentNode] == 1) {
            haveLoop = true;
            return;
        }
        // 这个节点已经访问过了 无须再次访问 并且已经存在于栈内
        if (visited[currentNode] == 2) {
            return;
        }
        // 访问当前节点
        visited[currentNode] = 1;
        List<Integer> edgeOfCurrentNode = edges.get(currentNode);
        for (int target : edgeOfCurrentNode) {
            dfs(target);
        }
        // 访问结束 将状态置为已访问完 并且压入栈中
        visited[currentNode] = 2;
        stack[indexOfLast++] = currentNode;
    }

    public static void main(String[] args) {
        int num = 2;
        int[][] arrays = {{0, 1}, {1, 0}};
        int[] result = new LeetCode210课程表II().findOrder(num, arrays);
        System.out.println(result);
    }
}
