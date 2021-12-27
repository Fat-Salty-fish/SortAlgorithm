package others;

/**
 * @author lizhongjie
 * @desc 并查集
 * 被广泛运用于判断一个图中是否有环等
 * @create_time 2021/11/15
 */
public class DisjointSet {

    /**
     * 用来记录所有节点的父节点
     */
    public int[] parent;

    /**
     * 可以通过ranks(秩)来缩短路径 也可以通过在find函数来进行压缩路径
     */
    public int[] ranks;

    /**
     * 初始化并查集
     *
     * @param nodes
     */
    public void init(int nodes) {
        parent = new int[nodes];
        ranks = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            // 初始情况下 每个节点的父节点是自己
            parent[i] = -1;
        }
    }

    /**
     * 寻找根节点
     * 一直寻找到最深处的根节点
     *
     * @param node
     * @return
     */
    public int findRoot(int node) {
        int root = node;
        while (parent[root] != -1) {
            // root是当前节点的父节点
            root = parent[root];
        }
        return root;
    }

    /**
     * 带有状态压缩的查询
     *
     * @param node
     * @return
     */
    public int findRootWithCut(int node) {
        if (parent[node] == -1) {
            return node;
        }
        parent[node] = findRootWithCut(parent[node]);
        return parent[node];
    }

    /**
     * 将两个节点合并在一起
     * 还需要边
     * edges[i]表示第i条边
     * edges[i][0]和edges[i][1]分别表示第i条边的两个节点
     * 返回false表示连接失败 返回true表示连接成功
     *
     * @param leftNode
     * @param rightNode
     * @return
     */
    public boolean union(int leftNode, int rightNode) {
        int leftRoot = findRoot(leftNode);
        int rightRoot = findRoot(rightNode);
        if (leftRoot == rightRoot) {
            return false;
        }
        if (ranks[leftRoot] > ranks[rightRoot]) {
            parent[rightRoot] = leftRoot;
        } else if (ranks[leftRoot] < ranks[rightRoot]) {
            parent[leftRoot] = rightRoot;
        } else {
            parent[leftRoot] = rightRoot;
            ranks[rightRoot]++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {2, 5}};
        int nodes = 6;
        DisjointSet disjointSet = new DisjointSet();
        disjointSet.init(nodes);
        for (int i = 0; i < edges.length; i++) {
            int leftNode = edges[i][0];
            int rightNode = edges[i][1];
            if (!disjointSet.union(leftNode, rightNode)) {
                System.out.println("有个环");
                return;
            }
        }
        System.out.println("没有环");
    }
}
