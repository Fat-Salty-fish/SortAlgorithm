package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/22
 */
public class LeetCode250统计同值子树 {

    /**
     * 统计同值子树
     *
     * @param root
     * @return
     */
    public int countUnivalSubtrees(TreeNode root) {
        return getCountOfUnivalSubtrees(root).count;
    }

    public ReturnType getCountOfUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return new ReturnType();
        }
        if (root.left == null && root.right == null) {
            ReturnType result = new ReturnType();
            result.isUnivalSubTree = true;
            result.univalValue = root.val;
            result.count = 1;
            return result;
        } else if (root.left == null) {
            ReturnType rightResult = getCountOfUnivalSubtrees(root.right);
            ReturnType result = new ReturnType();
            if (rightResult.isUnivalSubTree && root.val == rightResult.univalValue) {
                result.univalValue = root.val;
                result.count = rightResult.count + 1;
                result.isUnivalSubTree = true;
            } else {
                result.isUnivalSubTree = false;
                result.count = rightResult.count;
            }
            return result;
        } else if (root.right == null) {
            ReturnType leftResult = getCountOfUnivalSubtrees(root.left);
            ReturnType result = new ReturnType();
            if (leftResult.isUnivalSubTree && root.val == leftResult.univalValue) {
                result.univalValue = root.val;
                result.isUnivalSubTree = true;
                result.count = leftResult.count + 1;
            } else {
                result.isUnivalSubTree = false;
                result.count = leftResult.count;
            }
            return result;
        } else {
            ReturnType leftResult = getCountOfUnivalSubtrees(root.left);
            ReturnType rightResult = getCountOfUnivalSubtrees(root.right);
            ReturnType result = new ReturnType();
            if (leftResult.isUnivalSubTree && rightResult.isUnivalSubTree && root.val == leftResult.univalValue && root.val == rightResult.univalValue) {
                result.isUnivalSubTree = true;
                result.count = leftResult.count + rightResult.count + 1;
                result.univalValue = root.val;
            } else {
                result.count = leftResult.count + rightResult.count;
            }
            return result;
        }
    }


    /**
     * 返回值
     * 如果isUnivalSubTree为true
     * univalValue才有效
     */
    class ReturnType {
        boolean isUnivalSubTree;

        int univalValue;

        int count;
    }
}
