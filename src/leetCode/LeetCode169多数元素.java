package leetCode;

/**
 * @author acer
 * @Date 2019/6/18 9:12
 */
public class LeetCode169多数元素 {

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (current == nums[i]) {
                ++count;
            } else {
                --count;
            }
            if (count < 0) {
                current = nums[i];
                count = 1;
            }
        }
        return current;
    }

    /**
     * 二刷
     * "选举"方法 因为一个数的数量超过了一半 那么其余的数和最多的数进行"搭配"减去后 剩下的数一定是超过一半的数
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        int current = -1;
        for (int temp : nums) {
            if (count == 0) {
                current = temp;
                count++;
            } else if (current == temp) {
                count++;
            } else {
                count--;
            }
        }
        // 如果超过一半的数可能不存在 需要再遍历一次 判断当前current是不是超过一半的数
        return current;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 9, 9, 10};
        System.out.println(new LeetCode169多数元素().majorityElement(nums));
    }
}
