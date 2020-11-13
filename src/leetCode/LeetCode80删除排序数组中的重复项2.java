package leetCode;

import com.sun.codemodel.internal.JWhileLoop;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/8/15
 */
public class LeetCode80删除排序数组中的重复项2 {
    /**
     * 双指针 删除多余元素
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int left = 1;
        int right = 2;
        while (right < nums.length) {
            if (nums[right] != nums[left - 1]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left++;
    }

    public int removeDuplicatesForMyOwn(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        // 记住 left与right是指针！ 是地址 不是个数
        // 定义left和right的起始位置
        // 如果[0,left) 则left=k 如果[0,left] 则left=k-1
        // right = left+1
        int left = 1;
        int right = 2;
        while (right < nums.length) {
            if (nums[right] != nums[left - 1]) {
                // 先扩大这个数组的范围 有新的元素要添加进来
                left++;
                // 把新元素添加进来
                nums[left] = nums[right];
            }
            right++;
        }
        // 返回的是个数 所以要left+1
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        new LeetCode80删除排序数组中的重复项2().removeDuplicates(nums);
        System.out.println(nums);
    }
}
