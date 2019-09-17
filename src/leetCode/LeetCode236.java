package leetCode;

/**
 * @author acer
 * @Date 2019/8/17 19:22
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果当前结点是p或当前节点是q
        if (root == null || root == p || root == q) {
            //返回当前节点
            return root;
        }
        //在左子树下寻找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //在右子树下寻找p和q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }
}
