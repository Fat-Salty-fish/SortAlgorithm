package leetCode;

/**
 * @author acer
 * @Date 2019/8/25 2:39
 */
public class LeetCode34在排序数组中查找元素的第一个和最后一个元素 {
    //要求时间复杂度是logn级别 肯定是用二分查找了
    //要找两个数 一个是target对应的开头 一个是target对应的结尾
    //对数组进行两次二分查找
    //先找到左边界
    //再找到又边界
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int length = nums.length;
        int left;
        int right;

        int[] ans = new int[2];
        //先对左边界进行二分查找
        left = 0;
        //因为要寻找边界 所以为左闭右开
        right = length;

        //终止条件为 left = right
        while (left < right) {
            //获取中位
            int mid = (left + right) / 2;
            //如果中位的数为目标数 则在[left,mid)中继续寻找
            if (nums[mid] == target) {
                right = mid;
                //如果中位的数比目标数小 则在[mid,right)中继续寻找
            } else if (nums[mid] < target) {
                left = mid + 1;
                //如果中位的数比目标数大 则在[left,mid)中继续寻找
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == length) {
            ans[0] = -1;
        } else {
            ans[0] = nums[left] == target ? left : -1;
        }


        //对右边界进行二分查找
        left = 0;
        right = length;
        while (left < right) {
            int mid = (left + right) / 2;
            //如果中位的数等于目标数 则在[mid,right)中继续寻找
            if (nums[mid] == target) {
                left = mid + 1;
                //如果中位的数比目标数小 则在[mid,right)中继续寻找
            } else if (nums[mid] < target) {
                left = mid + 1;
                //如果中位的数比目标数大 则在[left,mid)中继续寻找
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) {
            ans[1] = -1;
        } else {
            ans[1] = nums[left - 1] == target ? left - 1 : -1;
        }

        return ans;
    }


    /**
     * 二分查找
     * 二刷
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        // 两次二分查询
        int[] result = {-1, -1};
        int numSize = nums.length;
        int left = 0;
        int right = numSize;
        // 寻找左边界
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == nums.length) {
            result[0] = -1;
        } else {
            result[0] = nums[left] == target ? left : -1;
        }
        left = 0;
        right = numSize;
        // 寻找右边界
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) {
            result[1] = -1;
        } else {
            result[1] = nums[right - 1] == target ? right - 1 : -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 2};
        int target = 0;
        int[] result = new LeetCode34在排序数组中查找元素的第一个和最后一个元素().searchRange2(array, target);
    }
}
