package leetCode;

/**
 * @author acer
 * @Date 2019/6/18 9:12
 */
public class LeetCode169 {

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int current = nums[0];
        for(int i = 1;i<nums.length; ++i){
            if(current == nums[i]){
                ++count;
            }else {
                --count;
            }
            if(count<0){
                current = nums[i];
                count = 1;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,9,9,10};
        System.out.println(new LeetCode169().majorityElement(nums));
    }
}
