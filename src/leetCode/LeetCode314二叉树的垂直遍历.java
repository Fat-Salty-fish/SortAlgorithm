package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/23
 */
public class LeetCode314二叉树的垂直遍历 {

    int max = Integer.MIN_VALUE;

    int min = Integer.MAX_VALUE;

    /**
     * 垂直遍历 其实就是先序遍历
     * 单纯的先序遍历并无法解决上下问题
     * 需要维护高度？但是高度如何维护呢
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, PriorityQueue<TempNode>> resultMap = new HashMap<>();
        verticalOrder(root, 0, resultMap, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (resultMap.containsKey(i)) {
                List<Integer> temp = new ArrayList<>();
                PriorityQueue<TempNode> pq = resultMap.get(i);
                while (!pq.isEmpty()) {
                    temp.add(pq.poll().value);
                }
                result.add(temp);
            }
        }
        return result;
    }

    public void verticalOrder(TreeNode root, int position, Map<Integer, PriorityQueue<TempNode>> orderList, int depth) {
        if (root == null) {
            return;
        }
        max = Math.max(max, position);
        min = Math.min(min, position);
        PriorityQueue<TempNode> currentList = orderList.getOrDefault(position, new PriorityQueue<>((o1, o2) -> o1.depth == o2.depth ? 0 : o1.depth - o2.depth));
        currentList.add(new TempNode(root.val, depth));
        orderList.put(position, currentList);
        verticalOrder(root.left, position - 1, orderList, depth + 1);
        verticalOrder(root.right, position + 1, orderList, depth + 1);
    }

    public class TempNode {
        public int value;
        public int depth;

        public TempNode() {

        }

        public TempNode(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }


    /**
     * 尝试层序遍历
     * 为什么层序遍历可以？
     * 因为在较下面的层里 有的同列同层的节点来源的父亲节点与原来的左右排列不相同
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder2(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                max = Math.max(max,temp.col);
                min = Math.min(min,temp.col);
                List<Integer> list = resultMap.getOrDefault(temp.col,new ArrayList<>());
                list.add(temp.treeNode.val);
                resultMap.put(temp.col,list);
                if (temp.treeNode.left!=null){
                    queue.offer(new Node(temp.treeNode.left,temp.col-1));
                }
                if (temp.treeNode.right!=null){
                    queue.offer(new Node(temp.treeNode.right,temp.col+1));
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = min;i<=max;i++){
            if (resultMap.containsKey(i)){
                result.add(resultMap.get(i));
            }
        }
        return result;
    }

    public class Node {

        // 树节点
        public TreeNode treeNode;

        // 节点列
        public int col;



        public Node() {

        }

        public Node(TreeNode value, int col) {
            this.treeNode = value;
            this.col = col;
        }
    }

}
