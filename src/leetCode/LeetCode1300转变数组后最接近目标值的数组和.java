package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/13
 */
public class LeetCode1300转变数组后最接近目标值的数组和 {

    /**
     * 感觉像是二分查找
     *
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        int length = arr.length;
        Arrays.sort(arr);
        // 二分查找的上下界
        // 二分查找范围的下界
        int min = 0;
        int max = arr[length - 1];
        int abs = target;
        int result = 0;
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre[i] = arr[i] + pre[i - 1];
        }
        for (int i = min; i <= max; i++) {
            int tempSum = 0;
            int indexOfSmaller = findIndexOfSmallerEqualOfTarget(arr, i);
            if (indexOfSmaller == -1) {
                tempSum = length * i;
            } else {
                tempSum += pre[indexOfSmaller];
                tempSum += (length - indexOfSmaller - 1) * i;
            }
            if (Math.abs(target - tempSum) < abs) {
                abs = Math.abs(target - tempSum);
                result = i;
            }
        }
        return result;
    }

    /**
     * 在有序数组里寻找比target小于或等于的最大的索引
     *
     * @param array
     * @param target
     * @return
     */
    public int findIndexOfSmallerEqualOfTarget(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        // 终止时 left = right+1 left和right不在一个位子上 应该返回right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                if (mid + 1 < array.length && array[mid + 1] > target) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5};
        Arrays.sort(array);
        int index = new LeetCode1300转变数组后最接近目标值的数组和().findBestValue(array, 11);
        System.out.println(index);
    }
}
