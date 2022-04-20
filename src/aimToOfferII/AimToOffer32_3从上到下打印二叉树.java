package aimToOfferII;

import leetCode.TreeNode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/31
 */
public class AimToOffer32_3从上到下打印二叉树 {

    /**
     * 添加一个参数是从左到右还是从右到左
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        boolean leftToRight = true;
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        queue.push(root);
        while (!queue.isEmpty() || !deque.isEmpty()) {
            List<Integer> tempResult = new ArrayList<>();
            if (leftToRight) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    tempResult.add(temp.val);
                    if (temp.left != null) {
                        deque.push(temp.left);
                    }
                    if (temp.right != null) {
                        deque.push(temp.right);
                    }
                }
            } else {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = deque.pop();
                    tempResult.add(temp.val);
                    if (temp.right != null) {
                        queue.push(temp.right);
                    }
                    if (temp.left != null) {
                        queue.push(temp.left);
                    }
                }
            }
            result.add(tempResult);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
