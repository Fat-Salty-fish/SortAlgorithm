package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/7/29 9:37
 */
public class LeetCode98验证二叉搜索树 {
//    public boolean isValidBST(TreeNode root) {
//        if (root != null) {
//            if(root.left == null && root.right == null){
//                return true;
//            }else if(root.left == null){
//                return root.val < root.right.val && isValidBST(root.right);
//            }else if(root.right == null){
//                return root.val > root.left.val && isValidBST(root.left);
//            }else {
//                return root.val < root.right.val && root.val > root.left.val && isValidBST(root.left) && isValidBST(root.right);
//            }
//        } else {
//            return true;
//        }
//    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fillInList(root, list);
        return isIncrement(list);
    }

    public void fillInList(TreeNode node, List<Integer> list) {
        if (node != null) {
            fillInList(node.left, list);
            list.add(node.val);
            fillInList(node.right, list);
        }
    }

    public boolean isIncrement(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size() && list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 二刷
     * 检查是否为二叉搜索树 即使用中序遍历 检查元素是否为单调递增即可
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBstHelp(root);
    }

    // 为什么要用long？因为可能树叶子节点的值是Integer.Min_VALUE 而这里使用Integer的话 就会导致校验失败
    public long lastMid = Long.MIN_VALUE;

    public boolean isValidBstHelp(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 先判断左子树
        boolean leftValid = isValidBstHelp(root.left);
        if (root.val <= lastMid) {
            return false;
        }
        lastMid = root.val;
        boolean rightValid = isValidBstHelp(root.right);
        return leftValid && rightValid;
    }

    /**
     * 二刷进阶 如何不使用递归中序遍历二叉树
     *
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        long lastMid = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= lastMid) {
                return false;
            }
            lastMid = node.val;
            node = node.right;
        }
        return true;
    }

    /**
     * 三刷 基本递归方法
     *
     * @param root
     * @return
     */
    public boolean isValidBST4(TreeNode root) {
        return isValidBST4Helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 用来判断当前树节点是否在某个范围之内
     *
     * @param root
     * @param leftValue
     * @param rightValue
     * @return
     */
    public boolean isValidBST4Helper(TreeNode root, Long leftValue, Long rightValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= leftValue || root.val >= rightValue) {
            return false;
        }
        return isValidBST4Helper(root.left, leftValue, (long) root.val) && isValidBST4Helper(root.right, (long) root.val, rightValue);
    }

    public static void main(String[] args) {
        Boolean result = new LeetCode98验证二叉搜索树().isValidBST2(new TreeNode(0));
        System.out.println(1);
    }
}
