package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/15
 */
public class LeetCode765情侣牵手 {


    /**
     * 情侣牵手 并查集的第一道题
     * 如何使用并查集来解决？
     * 并查集通常用来解决是否成环
     * 在此题中如何确定是一个环？
     *
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        int length = row.length;
        int couple = length / 2;
        DisjointSet disjointSet = new DisjointSet();
        disjointSet.init(couple);
        for (int i = 0; i < length; i = i + 2) {
            int leftNode = row[i] / 2;
            int rightNode = row[i + 1] / 2;
            disjointSet.union(leftNode, rightNode);
        }
        return couple - disjointSet.nodeNum;
    }

    public class DisjointSet {

        public int[] parent;

        /**
         * 此并查集中的连通分量个数
         */
        public int nodeNum;

        /**
         * 并查集初始化
         *
         * @param nodeNum
         */
        public void init(int nodeNum) {
            this.nodeNum = nodeNum;
            parent = new int[nodeNum];
            for (int i = 0; i < nodeNum; i++) {
                parent[i] = i;
            }
        }

        /**
         * 带有压缩路径的获取父节点
         *
         * @param node
         * @return
         */
        public int getFatherWithWhile(int node) {
            while (node != parent[node]) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }

        /**
         * 合并两个节点
         *
         * @param leftNode
         * @param rightNode
         * @return
         */
        public boolean union(int leftNode, int rightNode) {
            int leftRoot = getFatherWithWhile(leftNode);
            int rightRoot = getFatherWithWhile(rightNode);
            if (leftRoot == rightRoot) {
                return false;
            }
            // 连通分量个数减少
            nodeNum--;
            parent[leftRoot] = rightRoot;
            return true;
        }
    }

}
