package leetCode;

/**
 * @author acer
 * @Date 2019/8/22 21:25
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length - 1, target);
    }

    //对数字进行二分查找
    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[end] < target) {
                return start + 1;
            }
            if (nums[start] > target) {
                if (start == 0) {
                    return 0;
                }
            }
            return start;
        }
        int midPosition = (start + end) / 2;
        if (nums[midPosition] < target) {
            return binarySearch(nums, midPosition + 1, end, target);
        } else {
            return binarySearch(nums, start, midPosition, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode35().searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}
