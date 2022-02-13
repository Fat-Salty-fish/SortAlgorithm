package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/28
 */
public class LeetCode545二叉树的边界 {

    TreeNode treeRoot;

    /**
     * 判断一个节点是否为叶子节点
     *
     * @param root
     * @return
     */
    public boolean isLeafNode(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }

    public void addToLeftBorder(List<Integer> leftBorder, TreeNode root) {
        if (root == null || isLeafNode(root)) {
            return;
        }
        leftBorder.add(root.val);
        if (root.left != null) {
            addToLeftBorder(leftBorder, root.left);
        } else {
            addToLeftBorder(leftBorder, root.right);
        }
    }

    public void addToBottomBorder(List<Integer> bottomBorder, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root != treeRoot && isLeafNode(root)) {
            bottomBorder.add(root.val);
        } else {
            addToBottomBorder(bottomBorder, root.left);
            addToBottomBorder(bottomBorder, root.right);
        }
    }

    public void addToRightBorder(List<Integer> rightBorder, TreeNode root) {
        if (root == null || isLeafNode(root)) {
            return;
        }
        rightBorder.add(root.val);
        if (root.right != null) {
            addToRightBorder(rightBorder, root.right);
        } else {
            addToRightBorder(rightBorder, root.left);
        }
    }

    /**
     * @param root
     * @return
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftBorder = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        treeRoot = root;
        leftBorder.add(root.val);

        if (root.left != null) {
            addToLeftBorder(leftBorder, root.left);
        }

        List<Integer> bottomBorder = new ArrayList<>();
        addToBottomBorder(bottomBorder, root);

        List<Integer> rightBorder = new ArrayList<>();
        if (root.right != null) {
            addToRightBorder(rightBorder, root.right);
        }

        leftBorder.addAll(bottomBorder);
        Collections.reverse(rightBorder);
        leftBorder.addAll(rightBorder);
        return leftBorder;
    }

    public static void main(String[] args) {
    }
}
