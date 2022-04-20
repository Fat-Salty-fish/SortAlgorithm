package aimToOfferII;

import leetCode.TreeNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/26
 */
public class AimToOffer07重建二叉树 {


    /**
     * 根据前序遍历和中序遍历构建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 用前序遍历和中序遍历构建二叉树
     *
     * @param preOrder
     * @param preStart
     * @param preEnd
     * @param inOrder
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode head = new TreeNode(preOrder[preStart]);
        int index = inStart;
        for (; index <= inEnd; index++) {
            if (inOrder[index] == preOrder[preStart]) {
                break;
            }
        }
        int leftLength = index - inStart;
        int rightLength = inEnd - index + 1;

        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + leftLength - 1;
        int leftInStart = inStart;
        int leftInEnd = inStart + leftLength - 1;

        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd;
        int rightInStart = index + 1;
        int rightInEnd = rightInStart + rightLength - 1;
        head.left = buildTree(preOrder,leftPreStart,leftPreEnd,inOrder,leftInStart,leftInEnd);
        head.right = buildTree(preOrder,rightPreStart,rightPreEnd,inOrder,rightInStart,rightInEnd);
        return head;
    }
}
