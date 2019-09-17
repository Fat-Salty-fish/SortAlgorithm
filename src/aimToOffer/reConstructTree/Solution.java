package aimToOffer.reConstructTree;

/**
 * 重建二叉树 给定一个二叉树的前序遍历和中序遍历数组 重新构造出这一颗二叉树
 *
 * @author acer
 * @Date 2019/4/6 14:45
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return treeNode;
    }


    //使用递归方法来生成二叉树
    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre,
                                  int[] in, int startIn, int endIn) {
        //边界判断 输入的前序头和不能大于前序尾 中序头不能大于中序尾
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        //前序遍历的首数字即为根节点
        TreeNode node = new TreeNode(pre[startPre]);

        for(int i = startIn; i<=endIn ; i++){
            if(in[i] == pre[startPre]){
                node.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                node.right = reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return node;

//        if(startPre>endPre||startIn>endIn)
//            return null;
//        TreeNode root=new TreeNode(pre[startPre]);
//
//        for(int i=startIn;i<=endIn;i++)
//            if(in[i]==pre[startPre]){
//                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
//                root.right = reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
//                break;
//            }
//
//        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] in = new int[]{3, 2, 4, 1, 6, 5, 7};
        TreeNode root = new Solution().reConstructBinaryTree(pre, in);
        root.print();
    }
}
