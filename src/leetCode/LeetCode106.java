package leetCode;

/**
 * @author acer
 * @Date 2019/7/29 17:14
 */
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    public TreeNode build(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        TreeNode node = null;
        //证明这个树是有元素的
        if(postEnd - postStart > 0)
        {
            int val = postorder[postEnd-1];
            //对节点进行赋值
            node = new TreeNode(val);
            int i = inStart;
            for(;i<inEnd;i++){
                if(inorder[i] == val){
                    break;
                }
            }
            //左子树的节点个数
            int leftNum = i - inStart;
            //右子树的节点个数
            int rightNum = inEnd - i- 1;
            node.left = build(inorder,inStart,i,postorder,postEnd-1-rightNum-leftNum,postEnd-1-rightNum);
            node.right = build(inorder,i+1,i+1+rightNum,postorder,postEnd-1-rightNum,postEnd-1);
        }
        return node;
    }
}
