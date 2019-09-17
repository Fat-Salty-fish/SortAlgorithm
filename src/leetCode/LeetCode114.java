package leetCode;

/**
 * @author acer
 * @Date 2019/7/29 20:49
 */
public class LeetCode114 {
    //用来记录上一个节点
    public TreeNode preNode ;
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        if(preNode != null){
            preNode.right = root;
            preNode.left = null;
        }
        preNode = root;
        TreeNode temp = root.right;
        flatten(root.left);
        flatten(temp);
    }
}
