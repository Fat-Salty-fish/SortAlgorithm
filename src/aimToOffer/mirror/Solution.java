package aimToOffer.mirror;

/**
 * @author acer
 * @Date 2019/4/15 15:09
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    /**
     * 对树进行镜像操作
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(root.left.val + " " + root.right.val);
        System.out.println(node1.left.val + " " + node1.right.val);
        System.out.println(node2.left.val + " " + node2.right.val);

        new Solution().Mirror(root);
        System.out.println(root.left.val + " " + root.right.val);
        System.out.println(node1.left.val + " " + node1.right.val);
        System.out.println(node2.left.val + " " + node2.right.val);
    }
}
