package leetCode;

/**
 * @author acer
 * @Date 2019/8/23 23:56
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = left;
        while (left < nums.length) {
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            if (right == nums.length && nums[right - 1] == 0) {
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right = left;
        }
    }

    /**
     * 重做283
     * O(n)的方法(遍历两次list)
     *
     * @param nums
     */
    public void moveZeros2(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length || left < nums.length) {
            if (right != nums.length) {
                if (nums[right] != 0) {
                    nums[left++] = nums[right++];
                } else {
                    right++;
                }
            } else {
                nums[left++] = 0;
            }
        }
    }

    /**
     * 重做283
     * O(n)的方法 (遍历一次list)
     *
     * @param nums
     */
    public void moveZeros3(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int current = nums[left];
                nums[left] = nums[right];
                nums[right] = current;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        new LeetCode283().moveZeros3(array);
        System.out.println(array);
    }
}
