package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/22
 */
public class LeetCode298二叉树最长连续序列 {

    /**
     * 二叉树最长连续序列
     *
     * @param root
     * @return
     */
    public int longestConsecutive(TreeNode root) {
        return longestConsecutiveWithReturnType(root).longestList;
    }


    public ReturnType longestConsecutiveWithReturnType(TreeNode root) {
        if (root == null) {
            return new ReturnType();
        }
        if (root.left == null && root.right == null) {
            ReturnType returnType = new ReturnType();
            returnType.longestList = 1;
            returnType.longestListWithHead = 1;
            return returnType;
        }
        ReturnType leftResult = longestConsecutiveWithReturnType(root.left);
        ReturnType rightResult = longestConsecutiveWithReturnType(root.right);
        ReturnType result = new ReturnType();
        result.longestListWithHead = 1;
        if (root.left != null && root.val + 1 == root.left.val) {
            result.longestListWithHead = Math.max(result.longestListWithHead, leftResult.longestListWithHead + 1);
            leftResult.longestList = Math.max(leftResult.longestList, leftResult.longestListWithHead + 1);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            result.longestListWithHead = Math.max(result.longestListWithHead, rightResult.longestListWithHead + 1);
            rightResult.longestList = Math.max(rightResult.longestList, rightResult.longestListWithHead + 1);
        }
        result.longestList = Math.max(leftResult.longestList, rightResult.longestList);
        return result;
    }

    /**
     * 返回值
     */
    class ReturnType {
        //连同根节点的时候 最长的链表长度
        int longestListWithHead;

        int longestList;
    }

    int max;

    /**
     * 第二种办法 向下处理
     *
     * @param root
     * @return
     */
    public int longestConsecutive2(TreeNode root) {
        max = 0;
        help(root, -1, 0);
        return max;
    }


    public void help(TreeNode root, int parentValue, int currentLength) {
        max = Math.max(currentLength,max);
        if (root == null) {
            return;
        }
        if (currentLength != 0 && parentValue + 1 == root.val) {
            currentLength++;
        } else {
            currentLength = 1;
        }
        help(root.left, root.val, currentLength);
        help(root.right, root.val, currentLength);
    }
}
