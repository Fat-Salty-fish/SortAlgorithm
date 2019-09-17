package leetCode;

/**
 * @author acer
 * @Date 2019/7/29 10:14
 */
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    public TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        TreeNode current = null;
        //证明这个序列是有元素的
        if(preEnd-preStart>0){
            //前序遍历中的第一个元素就是根节点
            int val = preorder[preStart];
            current = new TreeNode(val);
            int i = inStart;
            for(;i<inEnd;i++){
                if(inorder[i] == val){
                    break;
                }
            }
            //i为中序遍历中的位置 i-inStart即为左子树的个数 inEnd - i -1 为 右子树个数
            int leftNum = i-inStart;
            int rightNum = inEnd - i -1;
            current.left = build(preorder,preStart+1,preStart+1 + leftNum , inorder, inStart, i);
            current.right = build(preorder, preStart+1+leftNum,preStart+1+leftNum+rightNum,inorder,i+1,i+1+rightNum);
        }
        return current;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,3};
        int[] in = new int[]{2,3,1};
        TreeNode root = new LeetCode105().buildTree(pre,in);
    }
}
