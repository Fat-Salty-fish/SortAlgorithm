package aimToOffer;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class AimToOffer51数组中的逆序对 {

    int contribute = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return contribute;
        }
        sort(nums, 0, nums.length - 1);
        return contribute;
    }

    /**
     * 归并排序
     *
     * @param nums
     * @return
     */
    public int[] sort(int[] nums, int start, int end) {
        if (end - start == 0) {
            return new int[]{nums[start]};
        }
        int length = end - start + 1;
        int mid = start + (end - start) / 2;
        int[] leftNums = sort(nums, start, mid);
        int[] rightNums = sort(nums, mid + 1, end);
        int[] result = new int[length];
        int leftIndex = 0;
        int rightIndex = 0;
        int i = 0;
        while (i < length) {
            if (leftIndex < leftNums.length && rightIndex < rightNums.length) {
                if (leftNums[leftIndex] < rightNums[rightIndex]) {
                    result[i] = leftNums[leftIndex];
                    leftIndex++;
                    i++;
                } else if (leftNums[leftIndex] > rightNums[rightIndex]) {
                    result[i] = rightNums[rightIndex];
                    contribute += leftNums.length - leftIndex;
                    rightIndex++;
                    i++;
                } else {
                    result[i] = leftNums[leftIndex];
                    leftIndex++;
                    i++;
                }
            } else if (leftIndex < leftNums.length) {
                result[i] = leftNums[leftIndex];
                leftIndex++;
                i++;
            } else {
                result[i] = rightNums[rightIndex];
                rightIndex++;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647};
        int result = new AimToOffer51数组中的逆序对().reversePairs(array);
        System.out.println(result);
    }
}
