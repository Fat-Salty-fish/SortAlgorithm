package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/12/8
 */
public class LeetCode226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode current = root.left;
        root.left = root.right;
        root.right = current;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 二刷反转二叉树
     * 模版: 前序遍历或后序遍历即可
     * 中序遍历会导致先反转之后子节点反转无效
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }
}
