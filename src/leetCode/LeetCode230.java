package leetCode;

/**
 * @author acer
 * @Date 2019/8/17 19:08
 */
public class LeetCode230 {
    //采用dfs 对二叉树进行中序遍历
    int ans = -1;
    int current = 0;
    public int kthSmallest(TreeNode root, int k) {
        mid(root,k);
        return ans;
    }

    public void mid(TreeNode node,int k){
        if(node == null){
            return ;
        }
        mid(node.left,k);
        if(current == k){
            return ;
        }
        current+=1;
        if(current == k){
            ans = node.val;
            return;
        }
        mid(node.right,k);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(4);
        head.left.right = new TreeNode(2);
        System.out.println(new LeetCode230().kthSmallest(head,1));
    }
}
