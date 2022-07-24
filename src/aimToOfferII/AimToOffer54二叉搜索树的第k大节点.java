package aimToOfferII;

import leetCode.TreeNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/5/9
 */
public class AimToOffer54二叉搜索树的第k大节点 {


    int count;

    int theK;

    int result = -1;

    /**
     * 中序遍历吧
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        count = 0;
        theK = k;
        mid(root);
        return result;
    }

    public void mid(TreeNode head) {
        if (head == null) {
            return;
        }
        mid(head.right);
        count++;
        if (count == theK) {
            result = head.val;
            return;
        }
        mid(head.left);
    }
}
