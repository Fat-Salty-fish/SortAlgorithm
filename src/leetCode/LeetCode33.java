package leetCode;

/**
 * @author acer
 * @Date 2019/8/5 22:46
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int border = findBorder(nums, 0, nums.length - 1);
        if (nums[border] == target) {
            return border;
        }
//        else if (nums[border - 1] < target) {
//            return -1;
//        }
        else {
            if (border == 0) {
                return binarySearch(nums, 0, nums.length - 1, target);
            } else {
                if(target >= nums[0]){
                    return binarySearch(nums, 0, border - 1, target);
                }else {
                    return binarySearch(nums,border,nums.length-1,target);
                }
            }
        }
    }

    public int findBorder(int[] nums, int start, int end) {
        if (nums[start] < nums[end]) {
            return 0;
        }
        while (start <= end) {
            int middle = (end + start) / 2;
            if (nums[middle] > nums[middle + 1]) {
                return middle + 1;
            } else {
                if (nums[middle] < nums[start]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return 0;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if(nums[start] >target || nums[end] < target){
            return -1;
        }
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            } else {
                if (target > nums[middle]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode33().search(new int[]{5,1,3}, 3));
    }
}
