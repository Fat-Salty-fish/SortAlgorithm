package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/26
 */
public class LeetCode287寻找重复数 {


    /**
     * 类似142题 快慢指针
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int left = 0;
        int right = slow;
        while (left != right){
            left = nums[left];
            right = nums[right];
        }
        return left;
    }
}
