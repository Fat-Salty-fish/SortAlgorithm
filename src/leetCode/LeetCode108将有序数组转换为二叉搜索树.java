package leetCode;

/**
 * @author acer
 * @Date 2019/7/26 12:50
 */
public class LeetCode108将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildByArray(nums,0,nums.length-1);
    }

    public TreeNode buildByArray(int[] nums,int start, int end){
        if(start > end || end < 0 || start > nums.length){
            return null;
        }
        TreeNode head = new TreeNode(nums[start + (end-start)/2]);
        head.left = buildByArray(nums,start,start+(end-start)/2-1);
        head.right = buildByArray(nums,start+(end-start)/2+1,end);
        return head;
    }

    /**
     * 有序数组转换为二叉搜索树 只需要不停地将数组二分 二分 二分 即可
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     *
     * @param nums 构建bst树的所有数 左闭右闭
     * @param start 开始索引
     * @param end 结束索引
     * @return
     */
    public TreeNode buildBST(int[] nums,int start,int end){
        if (nums.length == 0 || end < start) {
            return null;
        }
        /**
         * 数组中数
         */
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums,start,mid-1);
        root.right = buildBST(nums,mid+1,end);
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        System.out.println(new LeetCode108将有序数组转换为二叉搜索树().sortedArrayToBST(nums).val);
    }
}
