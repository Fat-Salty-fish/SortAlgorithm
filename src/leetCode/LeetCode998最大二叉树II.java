package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/5
 */
public class LeetCode998最大二叉树II {

    /**
     * 如果val比root大 则root直接作为val为根的节点的左子节点
     * 如果val比root小 则需要将val插入到root的右子节点的合适位置中
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode newHead = new TreeNode(val);
            newHead.left = root;
            return newHead;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
