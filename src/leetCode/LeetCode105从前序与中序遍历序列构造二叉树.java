package leetCode;

/**
 * @author acer
 * @Date 2019/7/29 10:14
 */
public class LeetCode105从前序与中序遍历序列构造二叉树 {
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


    /**
     * 二刷
     * 直接进行一个造的构
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildWithIndex(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 根据前序遍历、中序遍历和索引进行构造二叉树
     * 因为可以假设没有重复元素
     * 在中序遍历中查询到当前头节点之后
     * 需要计算出左节点范围和右节点范围
     * @param preOrder
     * @param preLeft
     * @param preRight
     * @param inOrder
     * @param inLeft
     * @param inRight
     * @return
     */
    public TreeNode buildWithIndex(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preOrder == null || inOrder == null || preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int currentHead = preOrder[preLeft];
        int numIndexInInOrder = numInIndex(inOrder, inLeft, inRight, currentHead);
        TreeNode headNode = new TreeNode(currentHead);
        int leftLength = numIndexInInOrder - inLeft;
        int rightLength = inRight - numIndexInInOrder;
        TreeNode leftNode = buildWithIndex(preOrder, preLeft + 1, preLeft + leftLength, inOrder, inLeft, numIndexInInOrder - 1);
        TreeNode rightNode = buildWithIndex(preOrder, preLeft + 1 + leftLength, preLeft + 1 + leftLength + rightLength, inOrder, numIndexInInOrder + 1, inRight);
        headNode.left = leftNode;
        headNode.right = rightNode;
        return headNode;
    }

    /**
     * 在中序序列中查询目标数的索引
     * 如果未查询到 返回-1
     * @param inOrder
     * @param inLeft
     * @param inRight
     * @return
     */
    public int numInIndex(int[] inOrder, int inLeft, int inRight, int target) {
        if (inOrder == null || inLeft > inRight) {
            return -1;
        }
        for (int i = inLeft; i <= inRight; i++) {
            if (inOrder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};
        TreeNode root = new LeetCode105从前序与中序遍历序列构造二叉树().buildTree2(pre,in);
        System.out.println(root);
    }
}
