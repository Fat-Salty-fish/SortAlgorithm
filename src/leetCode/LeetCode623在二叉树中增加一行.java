package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/10
 */
public class LeetCode623在二叉树中增加一行 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode head = new TreeNode(val);
            head.left = root;
            return head;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        int currentDepth = 1;
        while (!stack.isEmpty()) {
            int currentSize = stack.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode temp = stack.poll();
                // 下一行的节点需要替换掉
                if (currentDepth == depth - 1) {
                    TreeNode oriLeft = temp.left;
                    TreeNode oriRight = temp.right;
                    TreeNode nowLeft = new TreeNode(val);
                    TreeNode nowRight = new TreeNode(val);
                    temp.left = nowLeft;
                    temp.right = nowRight;
                    nowLeft.left = oriLeft;
                    nowRight.right = oriRight;
                } else {
                    if (temp.left != null) {
                        stack.offer(temp.left);
                    }
                    if (temp.right != null) {
                        stack.offer(temp.right);
                    }
                }
            }
            if (currentDepth == depth - 1) {
                break;
            }
            currentDepth++;
        }
        return root;
    }
}
