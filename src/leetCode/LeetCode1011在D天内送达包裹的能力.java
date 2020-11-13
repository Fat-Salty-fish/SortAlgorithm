package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/9/17
 */
public class LeetCode1011在D天内送达包裹的能力 {
    // 二分查找 区间 [max(weights),sum(weights)]
    // 在此区间内寻找一个最小值 来计算是否能够满足D
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for (int a : weights) {
            left = Math.max(left, a);
            right += a;
        }
        // [left,right-1]
        // 因为这里是< 没有= 所以下面计算时right = mid
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 1;
            int temp = 0;
            for (int a : weights) {
                temp += a;
                if (temp > mid) {
                    temp = a;
                    count++;
                }
            }
            if (count < D) {
                right = mid;
            } else if (count == D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int day = 5;
        int result = new LeetCode1011在D天内送达包裹的能力().shipWithinDays(nums, day);
        System.out.println(result);
    }
}
