package leetCode;

/**
 * @author acer
 * @Date 2019/7/29 20:49
 */
public class LeetCode114二叉树展开为链表 {
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

    /**
     * 二刷114题
     * 将一个二叉树平铺成一个链表
     * @param root
     */
    public void flatten2(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left == null){
            flatten2(root.right);
            return;
        }
        if (root.right == null){
            root.right = root.left;
            root.left = null;
            return;
        }
        // 平铺左子树
        flatten2(root.left);
        // 平铺右子树
        flatten2(root.right);
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        root.left = null;
        root.right = tempLeft;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = tempRight;
    }
}
