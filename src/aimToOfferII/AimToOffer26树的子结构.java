package aimToOfferII;

import leetCode.TreeNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer26树的子结构 {


    /**
     * 树的子结构
     * 如何判断是否为子结构 这里需要什么？如果用后序遍历 则期望从左右子节点中获取什么？
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val) {
            boolean left = true;
            if (B.left != null) {
                left = isSameFromHead(A.left, B.left);
            }
            boolean right = true;
            if (B.right != null) {
                right = isSameFromHead(A.right, B.right);
            }
            return isSubStructure(A.left, B) || isSubStructure(A.right, B) || (left && right);
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    /**
     * 从头节点开始 b是a的子结构
     * @param a
     * @param b
     * @return
     */
    public boolean isSameFromHead(TreeNode a,TreeNode b){
        if (a == null && b == null){
            return true;
        }
        if (a == null){
            return false;
        }
        if (b == null){
            return true;
        }
        if (a.val != b.val){
            return false;
        }
        return isSameFromHead(a.left,b.left) && isSameFromHead(a.right,b.right);
    }
}
