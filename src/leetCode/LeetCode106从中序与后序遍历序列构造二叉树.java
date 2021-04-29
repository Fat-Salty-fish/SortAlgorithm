package leetCode;

/**
 * @author acer
 * @Date 2019/7/29 17:14
 */
public class LeetCode106从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        TreeNode node = null;
        //证明这个树是有元素的
        if (postEnd - postStart > 0) {
            int val = postorder[postEnd - 1];
            //对节点进行赋值
            node = new TreeNode(val);
            int i = inStart;
            for (; i < inEnd; i++) {
                if (inorder[i] == val) {
                    break;
                }
            }
            //左子树的节点个数
            int leftNum = i - inStart;
            //右子树的节点个数
            int rightNum = inEnd - i - 1;
            node.left = build(inorder, inStart, i, postorder, postEnd - 1 - rightNum - leftNum, postEnd - 1 - rightNum);
            node.right = build(inorder, i + 1, i + 1 + rightNum, postorder, postEnd - 1 - rightNum, postEnd - 1);
        }
        return node;
    }

    /**
     * 二刷
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return buildWithIndex(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildWithIndex(int[] inOrder, int inLeft, int inRight, int[] postOrder, int postLeft, int postRight) {
        if (inOrder == null || inLeft > inRight || postLeft > postRight) {
            return null;
        }
        // 后序遍历中的最后一个节点为整棵树的根节点
        int lastOfPost = postOrder[postRight];
        int indexOfRoot = searchInInOrder(inOrder, inLeft, inRight, lastOfPost);
        // 左子树所在数组中的长度
        int lengthOfLeft = indexOfRoot - inLeft;
        // 右子树所在数组中的长度
        int lengthOfRight = inRight - indexOfRoot;
        // 构造根节点
        TreeNode rootNode = new TreeNode(lastOfPost);
        // 构造左子树
        rootNode.left = buildWithIndex(inOrder, inLeft, indexOfRoot - 1, postOrder, postLeft, postLeft + lengthOfLeft - 1);
        // 构造右子树
        rootNode.right = buildWithIndex(inOrder, indexOfRoot + 1, inRight, postOrder, postRight - lengthOfRight, postRight - 1);
        return rootNode;
    }

    /**
     * 在中序遍历中查找目标数的位置
     *
     * @param inOrder
     * @param inLeft
     * @param inRight
     * @param target
     * @return
     */
    public int searchInInOrder(int[] inOrder, int inLeft, int inRight, int target) {
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
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        int[] postOrder = new int[]{9, 15, 7, 20, 3};
        TreeNode node = new LeetCode106从中序与后序遍历序列构造二叉树().buildTree2(inOrder, postOrder);
        System.out.println("result");
    }

}
