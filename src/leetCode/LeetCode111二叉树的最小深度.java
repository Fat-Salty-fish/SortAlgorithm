package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author acer
 * @Date 2019/7/26 18:49
 */
public class LeetCode111二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //证明它是叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 二叉树bfs
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(new LeetCode111二叉树的最小深度().minDepth2(node1));
    }
}
