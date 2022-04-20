package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/26
 */
public class AimToOffer11旋转数组最小的数字 {

    /**
     * 从后往前找
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int fromBehind = numbers.length - 1;
        while (fromBehind >= 1) {
            if (numbers[fromBehind - 1] > numbers[fromBehind]) {
                return numbers[fromBehind];
            }
            fromBehind--;
        }
        return numbers[fromBehind];
    }

    /**
     * 其实是二分查找 真的可以
     *
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                // 有可能当前的mid就是结果 如果直接right=mid-1就会导致结果被排除掉
                if (mid == 0 || numbers[mid - 1] > numbers[mid]) {
                    return numbers[mid];
                }
                right = mid - 1;
            } else {
                // num[mid] 与num[right]相等时 不能轻易忽略左半部分和右半部分 但是可以忽略右半部分
                right = mid;
            }
        }
        // 为什么返回left？
        return numbers[left];
    }
}
