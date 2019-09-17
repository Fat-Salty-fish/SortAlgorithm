package leetCode;

/**
 * @author acer
 * @Date 2019/7/26 18:49
 */
public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //证明它是叶子节点
        if(root.left == null && root.right == null)
            return 1;


        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if(root.left == null){
            return rightDepth+1;
        }
        if (root.right == null){
            return leftDepth+1;
        }
        return Math.min(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(new LeetCode111().minDepth(node1));
    }
}
