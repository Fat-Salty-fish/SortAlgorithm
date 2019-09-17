package leetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/26 12:50
 */
public class LeetCode108 {
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

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        System.out.println(new LeetCode108().sortedArrayToBST(nums).val);
    }
}
