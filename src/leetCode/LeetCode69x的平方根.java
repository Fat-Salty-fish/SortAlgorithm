package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/3
 */
public class LeetCode69x的平方根 {

    /**
     * 算数平方根 感觉可以用二分搜索来查找
     * 这个二分查找应该属于变种 类似于寻找左边界还是右边界？
     * 相当于寻找右边界
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 寻找右区间
     * 看来在某些情况下还只能使用left<=right的方法
     * 比如现在 right=x+1 x=Integer.MAX_VALUE就会导致溢出
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        int left = 0;
        int right = x + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 小心溢出问题
            if ((long) mid * mid == x) {
                left = mid + 1;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else if ((long) mid * mid > x) {
                right = mid;
            }
        }
        return right - 1;
    }

    public int mySqrt3(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == x) {
                left = mid + 1;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else if ((long) mid * mid > x) {
                right = mid - 1;
            }
        }
        if (right < 0 || (long) right * right > x) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int x = 4;
        int result = new LeetCode69x的平方根().mySqrt3(x);
        System.out.println("结果为" + result);
    }
}
