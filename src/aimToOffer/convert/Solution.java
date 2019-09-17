package aimToOffer.convert;

import sortFunctions.HeapSort;

/**
 * @author acer
 * @Date 2019/4/21 17:59
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class Solution {
    TreeNode preNode = null;
    TreeNode result = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertToList(pRootOfTree);
        return result;
    }

    public void ConvertToList(TreeNode currentNode) {
        //如果给定的节点为空 则直接返回空
        if (currentNode == null) {
            return;
        }
        //中序遍历
        //先遍历左子树
        ConvertToList(currentNode.left);
        //访问根节点
        if (preNode == null) {
            preNode = currentNode;
            result = currentNode;
        } else {
            preNode.right = currentNode;
            currentNode.left = preNode;
            preNode = currentNode;
        }
        //再遍历右子树
        ConvertToList(currentNode.right);
    }


}
