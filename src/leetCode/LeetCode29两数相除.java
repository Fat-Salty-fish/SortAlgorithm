package leetCode;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/2
 */
public class LeetCode29两数相除 {

    /**
     * 二分查找
     * 如何转换问题？查找的是什么数？
     * 不让用mod 乘法 除法 能想到的办法就是位运算了 左移/右移
     * 如果挨个尝试 时间复杂度就是O(n)
     * 使用二分查找即可
     * 如何判断找到了目标之数？
     * 不会了 看的官方题解
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            return 0;
        }
        boolean needToReverse = false;
        int reverseDividend = dividend;
        int reverseDivisor = divisor;
        if (dividend < 0) {
            needToReverse = true;
            reverseDividend = -reverseDividend;
        }
        if (divisor < 0) {
            needToReverse = !needToReverse;
            reverseDivisor = -reverseDivisor;
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        int result = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            boolean checkResult = quickCheck(reverseDivisor, mid, reverseDividend);
            // 符合 z*y>=x
            if (checkResult) {
                result = mid;
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (needToReverse) {
            result = -result;
        }
        return result;
    }

    /**
     * 快速乘
     * 设Z为商 Y为除数 X为被除数 Z为目标所求数
     * X Y为负数 Z为正数
     * 判断Z*Y >=X是否成立
     *
     * @param y
     * @param z
     * @param x
     * @return
     */
    public boolean quickCheck(int y, int z, int x) {
        int result = 0;
        int add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
//                if (result < x - add) {
//                    return false;
//                }
                result += add;
            }
//            if (z != 1) {
//                if (add < x - add) {
//                    return false;
//                }
//                add += add;
//            }
            add += y;
            z = z >> 1;
        }
        return result == x;
    }

    /**
     * 忘了怎么做了都
     * 官方题解 二分查找？
     * 先考虑边界情况 最大值最小值
     */
    public int divide2(int dividend, int divisor) {
        // 除数是0 结果为0
        if (divisor == 0) {
            return 0;
        }
        // 除数是1 直接返回
        if (divisor == 1) {
            return dividend;
        }
        // 除数是-1 并且被除数是最小值，那么直接除会溢出 返回最大值
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MAX_VALUE) {
            if (dividend == Integer.MAX_VALUE) {
                return 1;
            }
            return 0;
        }

        // 都用负数
        // reverse用来表示结果是否需要反转
        boolean reverse = false;
        if (dividend > 0) {
            dividend = -dividend;
            reverse = !reverse;
        }

        if (divisor > 0) {
            divisor = -divisor;
            reverse = !reverse;
        }

        // 恐怖的二分查找
        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
        }


        return 0;
    }

    public static void main(String[] args) {
//        int dividend = 10;
//        int divisor = 3;
//        int result = new LeetCode29两数相除().divide(dividend, divisor);
//        System.out.println("结果为:" + result);
//
//        int x = 9;
//        int y = 3;
//        int z = 3;
//        boolean check = new LeetCode29两数相除().quickCheck(y, z, x);
    }
}
