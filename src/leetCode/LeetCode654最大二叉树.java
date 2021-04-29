package leetCode;

/**
 * @author acer
 * @Date 2019/8/31 15:58
 */
public class LeetCode654最大二叉树 {

    /**
     * 构建一颗最大二叉树
     * 当前数组的最大值表示根节点
     * 然后用数组的左半区和右半区的数组构造左右子树
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 直接进行一个构的造
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 构建最大二叉树
     * @param nums 数组
     * @param left 数组左边界
     * @param right 数组右边界
     * @return
     */
    public TreeNode build(int[] nums, int left, int right) {
        if (right < left || nums.length < right) {
            return null;
        }
        int maxIndex = findMaxIndex(nums, left, right);
        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        TreeNode leftNode = build(nums, left, maxIndex - 1);
        TreeNode rightNode = build(nums, maxIndex + 1, right);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        return treeNode;
    }

    /**
     * 查询数组范围内最大的数
     * left、right 左闭右闭
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int findMaxIndex(int[] nums,int left,int right){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (left > right) {
            return -1;
        }
        if (left == right){
            return left;
        }
        int result = left;
        while (left <= right) {
            if (nums[result] < nums[left]) {
                result = left;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        LeetCode654最大二叉树 myMaxTree = new LeetCode654最大二叉树();
        TreeNode root = myMaxTree.constructMaximumBinaryTree(nums);
        System.out.println(root);
    }
}
