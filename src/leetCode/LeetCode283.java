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
            if(right == nums.length && nums[right-1] ==0){
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right = left;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        new LeetCode283().moveZeroes(array);
    }
}
