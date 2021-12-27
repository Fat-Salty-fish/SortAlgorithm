package leetCode;

/**
 * @author acer
 * @Date 2019/8/19 21:29
 */
public class LeetCode4寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //处理某个数组长度为0的情况
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
            } else {
                return (1.0 * nums2[n / 2]);
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
            } else {
                return (1.0 * nums1[m / 2]);
            }
        }

        int total = m + n;
        //如果是奇数的情况
        if ((total & 1) == 1) {
            return find_kth(nums1, nums2, 0, 0, total / 2 + 1);
        }
        return (find_kth(nums1, nums2, 0, 0, total / 2) + find_kth(nums1, nums2, 0, 0, total / 2 + 1)) / 2.0;
    }

    //寻找a和b中第k个数字
    private double find_kth(int[] nums1, int[] nums2, int aStart, int bStart, int k) {
        //当a 或者 b超过数组长度 则第k个数为另外一个数组的第k个数
        if (aStart >= nums1.length) {
            return nums2[bStart + k - 1];
        }
        if (bStart >= nums2.length) {
            return nums1[aStart + k - 1];
        }
        //k=1时 返回两个数组第一个数中最小的那一个数
        if (k == 1) {
            return Math.min(nums1[aStart], nums2[bStart]);
        }

        //midA 表示A数组的第k/2个数 midB表示B数组的第k/2个数
        int midA = Integer.MAX_VALUE;
        int midB = Integer.MAX_VALUE;

        if (aStart + k / 2 - 1 < nums1.length) {
            midA = nums1[aStart + k / 2 - 1];
        }
        if (bStart + k / 2 - 1 < nums2.length) {
            midB = nums2[bStart + k / 2 - 1];
        }

        if (midA < midB) {
            return find_kth(nums1, nums2, aStart + k / 2, bStart, k - k / 2);
        }
        return find_kth(nums1, nums2, aStart, bStart + k / 2, k - k / 2);
    }

    /**
     * 二刷 查找两个数组合并后的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int lengthOf1 = nums1.length;
        int lengthOf2 = nums2.length;
        // 当一个数组为空时 返回另一个数组的中位数
        if (lengthOf1 == 0) {
            if (lengthOf2 % 2 == 0) {
                return (nums2[lengthOf2 / 2 - 1] + nums2[lengthOf2 / 2]) / 2.0;
            } else {
                return 1.0 * nums2[lengthOf2 / 2];
            }
        }
        if (lengthOf2 == 0) {
            if (lengthOf1 % 2 == 0) {
                return (nums1[lengthOf1 / 2 - 1] + nums1[lengthOf1 / 2]) / 2.0;
            } else {
                return 1.0 * nums1[lengthOf1 / 2];
            }
        }
        int totalLength = lengthOf1 + lengthOf2;

        // 奇数
        if (totalLength % 2 != 0) {
            return findKNumFromTwoArray(nums1, nums2, 0, 0, totalLength / 2 + 1);
        } else {
            return (findKNumFromTwoArray(nums1, nums2, 0, 0, totalLength / 2) + findKNumFromTwoArray(nums1, nums2, 0, 0, totalLength / 2 + 1)) / 2.0;
        }
    }

    /**
     * 在两个有序数组中寻找第k个大的数
     *
     * @param nums1
     * @param nums2
     * @param startOf1
     * @param startOf2
     * @param k
     * @return
     */
    public double findKNumFromTwoArray(int[] nums1, int[] nums2, int startOf1, int startOf2, int k) {
        if (startOf1 >= nums1.length) {
            return 1.0 * nums2[startOf2 + k - 1];
        }
        if (startOf2 >= nums2.length) {
            return 1.0 * nums1[startOf1 + k - 1];
        }

        // 如果k == 1 则返回两个数组首位数里 更小的那个数字
        if (k == 1) {
            return Math.min(nums1[startOf1], nums2[startOf2]);
        }

        // 缩小范围
        int midA = Integer.MAX_VALUE;
        int midB = Integer.MAX_VALUE;

        // 这里是为什么？
        //
        if (startOf1 + k / 2 - 1 < nums1.length) {
            midA = nums1[startOf1 + k / 2 - 1];
        }
        if (startOf2 + k / 2 - 1 < nums2.length) {
            midB = nums2[startOf2 + k / 2 - 1];
        }

        // 舍弃数组a从startOf1 到 startOf1+k/2-1的元素 否则舍弃的是数组b
        if (midA < midB) {
            return findKNumFromTwoArray(nums1, nums2, startOf1 + k / 2, startOf2, k - k / 2);
        }
        return findKNumFromTwoArray(nums1, nums2, startOf1, startOf2 + k / 2, k - k / 2);
    }
}
