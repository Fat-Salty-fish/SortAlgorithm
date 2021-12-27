package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/3
 */
public class LeetCode172阶乘后的零 {


    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            int num = n % 5;
            n /= 5;
            result += num;
        }
        return result;
    }
}
