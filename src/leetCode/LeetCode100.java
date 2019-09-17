package leetCode;

/**
 * @author acer
 * @Date 2019/7/26 10:10
 */
public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null || q == null)&&(!(p == null && q == null))){
            return false;
        }
        return (p == null && q == null) || p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
