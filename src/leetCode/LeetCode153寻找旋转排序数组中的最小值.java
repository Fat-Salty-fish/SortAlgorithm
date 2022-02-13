package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/26
 */
public class LeetCode153寻找旋转排序数组中的最小值 {

    /**
     * 感觉是二分查找
     * 先遍历一次 找到直到不是省序的第一个值 否则返回数组的第一个
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    /**
     * 二分查找 但是二分查找的精髓好像很难理解...
     * 这里寻找的数是数组中的最小元素
     * 此最小元素并不在数组首位
     * 如何往二分查找上面思考呢？
     * 首先是有序数组 那么理论上 越往数组右边 数字越大
     * 所以求mid时 nums[mid]只要与搜索区间的最右端进行比较即可
     * 如果nums[mid] < nums[right] 说明处于递增序列 将mid-right范围舍去
     * 如果nums[mid] = nums[right] 这道题无法求解 但是因为题目里要求了数组内元素不相同 所以不会出现此情况
     * 如果nums[mid] > nums[right] 说明在mid-right中间有一个最小值 否则不可能出现这种情况 所以将left-mid区间舍去
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midNum = nums[mid];
            if (midNum < nums[right]) {
                // 这里不能把right = mid - 1 考虑一种情况 即mid就是最小值 此时如果right = mid-1就会把正确答案排除在外
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }


    public int findMin3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                if (mid == 0 || nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 2};
        int result = new LeetCode153寻找旋转排序数组中的最小值().findMin3(array);
        System.out.println(result);
    }
}
