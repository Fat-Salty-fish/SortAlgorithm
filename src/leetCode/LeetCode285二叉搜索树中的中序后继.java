package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/22
 */
public class LeetCode285二叉搜索树中的中序后继 {

    /**
     * 中序后继
     * 只需要用迭代的方式中序遍历即可
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode temp = root;
        while (temp != null || !deque.isEmpty()) {
            while (temp != null) {
                deque.push(temp);
                temp = temp.left;
            }
            temp = deque.pop();
            if (temp == p) {
                if (temp.right != null) {
                    TreeNode right = temp.right;
                    while (right.left != null) {
                        right = right.left;
                    }
                    return right;
                }else if (!deque.isEmpty()){
                    return deque.peek();
                }else {
                    return null;
                }
            }
            temp = temp.right;
        }
        return null;
    }
}
