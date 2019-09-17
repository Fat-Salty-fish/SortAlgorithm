package leetCode;

/**
 * @author acer
 * @Date 2019/8/19 21:29
 */
public class LeetCode4 {
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
        if(k == 1){
            return Math.min(nums1[aStart],nums2[bStart]);
        }

        //midA 表示A数组的第k/2个数 midB表示B数组的第k/2个数
        int midA = Integer.MAX_VALUE;
        int midB = Integer.MAX_VALUE;

        if(aStart + k/2 -1 < nums1.length){
            midA = nums1[aStart+k/2-1];
        }
        if(bStart +k/2-1 < nums2.length){
            midB = nums2[bStart+k/2-1];
        }

        if(midA<midB){
            return find_kth(nums1,nums2,aStart+k/2,bStart,k-k/2);
        }
        return find_kth(nums1,nums2,aStart,bStart+k/2,k-k/2);
    }
}
