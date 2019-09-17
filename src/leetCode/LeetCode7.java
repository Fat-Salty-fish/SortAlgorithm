package leetCode;

/**
 * @author acer
 * @Date 2019/7/10 23:01
 */
public class LeetCode7 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     */
    public int reverse(int x) {
        //用来返回
        int result = 0;
        while (x != 0) {
            //获取末位数字
            int temp = x % 10;
            x = x / 10;
            if(result > Integer.MAX_VALUE/10||(result == Integer.MAX_VALUE/10&&temp>7))
                return 0;
            if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10&&temp<-8))
                return 0;
            //结果计算
            result = result * 10 + temp;
        }
        return result;
    }
}
