package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/9/17
 */
public class LeetCode410分割数组的最大值 {

    /**
     * 结果区间:[max(nums),sum(nums)]
     * 即 在所有数中的最大值与所有数之和中寻找一个值
     * 这个值表示在原数组被划分为m个之后 所有数组的元素之和的最大值最小
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        // [max(nums),sum(nums)]
        for (int a : nums) {
            left = Math.max(left, a);
            right += a;
        }
        // 开始检索
        while (left < right) {
            // mid为一个结果 表示划分结果后最大的子数组之和
            int mid = (left + right) / 2;
            // count表示为符合条件的数组数量 起始就有1个数组
            int count = 1;
            // 子数组之和的最大值
            int sum = 0;
            for (int a : nums) {
                sum += a;
                if (sum > mid) {
                    // 得重新划分一个数组了 和从当前数组开始计算
                    sum = a;
                    // 一个新的数组
                    count++;
                }
            }
            // 判断按照当前划分下的数组个数是否满足
            // 如果比m大 说明mid太小了 区间:[mid+1,right]
            if (count > m) {
                left = mid + 1;
            } else {
                // 否则[left,mid]
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        int m = 2;
        int result = new LeetCode410分割数组的最大值().splitArray(nums, m);
    }
}
