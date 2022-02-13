package interviewGuide;

import leetCode.TreeNode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/11
 */
public class InterviewGuide166找到二叉树中的最大搜索二叉子树 {
    /**
     * 获得最大子二叉搜索树的头节点
     *
     * @param head
     * @return
     */
    public TreeNode getMaxChildBSTTree(TreeNode head) {
        return getMaxChildBSTTreeWithReturnType(head).maxChildBSTHead;
    }


    public ReturnType getMaxChildBSTTreeWithReturnType(TreeNode head) {
        if (head == null) {
            return null;
        }
        ReturnType result = new ReturnType();
        ReturnType leftResult = getMaxChildBSTTreeWithReturnType(head.left);
        ReturnType rightResult = getMaxChildBSTTreeWithReturnType(head.right);
        if (leftResult != null && rightResult != null) {
            if (leftResult.maxChildBSTHead == head.left && rightResult.maxChildBSTHead == head.right && head.val > leftResult.max && head.val < rightResult.min) {
                result.maxChildBSTHead = head;
                result.maxBSTSize = leftResult.maxBSTSize + rightResult.maxBSTSize + 1;
                result.min = leftResult.min;
                result.max = rightResult.max;
                return result;
            } else {
                return leftResult.maxBSTSize > rightResult.maxBSTSize ? leftResult : rightResult;
            }
        }
        if (leftResult != null) {
            return leftResult;
        } else if (rightResult != null) {
            return rightResult;
        } else {
            result.maxChildBSTHead = head;
            result.maxBSTSize = 1;
            result.min = head.val;
            result.max = head.val;
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(6);
        TreeNode head2 = new TreeNode(1);
        TreeNode head3 = new TreeNode(12);
        TreeNode head4 = new TreeNode(0);
        TreeNode head5 = new TreeNode(3);
        TreeNode head6 = new TreeNode(10);
        TreeNode head7 = new TreeNode(13);
        TreeNode head8 = new TreeNode(4);
        TreeNode head9 = new TreeNode(14);
        TreeNode head10 = new TreeNode(20);
        TreeNode head11 = new TreeNode(16);
        TreeNode head12 = new TreeNode(2);
        TreeNode head13 = new TreeNode(5);
        TreeNode head14 = new TreeNode(11);
        TreeNode head15 = new TreeNode(15);
        head1.left = head2;
        head1.right = head3;
        head2.left = head4;
        head2.right = head5;
        head3.left = head6;
        head3.right = head7;
        head6.left = head8;
        head6.right = head9;
        head7.left = head10;
        head7.right = head11;
        head8.left = head12;
        head8.right = head13;
        head9.left = head14;
        head9.right = head15;
        TreeNode result = new InterviewGuide166找到二叉树中的最大搜索二叉子树().getMaxChildBSTTree(head1);
        System.out.println(result.val);

    }
}

class ReturnType {
    /**
     * 最大子二叉搜索树的头节点
     */
    public TreeNode maxChildBSTHead;

    /**
     * 最大子二叉搜索树的规模大小
     */
    public int maxBSTSize;

    /**
     * 此子二叉搜索树的最大值
     */
    public int min;

    /**
     * 此子二叉搜索树的最小值
     */
    public int max;
}
