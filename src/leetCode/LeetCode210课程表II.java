package leetCode;

import java.util.*;

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

    /**
     * 拓扑排序 + BFS？
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> targets = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        // 初始化
        for (int i = 0; i < numCourses; i++) {
            targets.put(i, new HashSet<>());
            inDegrees.put(i, 0);
        }

        // 构建邻接矩阵和入度map
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int target = edge[0];
            Set<Integer> targetSet = targets.getOrDefault(from, new HashSet<>());
            targetSet.add(target);
            inDegrees.put(target, inDegrees.getOrDefault(target, 0) + 1);
            targets.put(from, targetSet);
        }
        List<Integer> result = new ArrayList<>();

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        // 初始化
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();
                Set<Integer> targetSet = targets.get(currentNode);
                for (int target : targetSet) {
                    inDegrees.put(target, inDegrees.get(target) - 1);
                    if (inDegrees.get(target) == 0) {
                        queue.offer(target);
                    }
                }
                result.add(currentNode);
            }
        }

        if (result.size() != numCourses) {
            return new int[0];
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int num = 2;
        int[][] arrays = {{1, 0}};
        int[] result = new LeetCode210课程表II().findOrder2(num, arrays);
        System.out.println(Arrays.toString(result));
    }
}
