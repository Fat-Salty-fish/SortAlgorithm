package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/9/17
 */
public class LeetCode852山脉数组的峰顶索引 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isLessThanMid(arr, mid) && isBiggerThanMid(arr, mid)) {
                return mid;
            } else if (!isLessThanMid(arr, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid + 1] > arr[mid]) {
                left = mid + 1;
            } else if (arr[mid -1] > arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public boolean isLessThanMid(int[] arr, int mid) {
        for (int i = 0; i < mid; i++) {
            if (arr[i] > arr[mid]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBiggerThanMid(int[] arr, int mid) {
        for (int i = mid + 1; i < arr.length; i++) {
            if (arr[i] > arr[mid]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1};
        int result = new LeetCode852山脉数组的峰顶索引().peakIndexInMountainArray(array);
        System.out.println(result);
    }
}
