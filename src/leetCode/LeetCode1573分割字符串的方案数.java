package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/6
 */
public class LeetCode1573分割字符串的方案数 {


    public int mod = 1000000007;

    /**
     * 时间复杂度n方 s太长时会造成时间太长的问题
     * 通过一些数学方法可以降低到On
     *
     * @param s
     * @return
     */
    public int numWays(String s) {
        if (s == null || s.length() < 3) {
            return 0;
        }
        int stringLength = s.length();
        int[] mem = new int[stringLength + 1];
        for (int i = 1; i <= stringLength; i++) {
            mem[i] = mem[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
        }
        int result = 0;
        for (int i = 1; i < stringLength; i++) {
            for (int j = i + 1; j < stringLength; j++) {
                int leftStringNum = mem[i];
                int midStringNum = mem[j] - mem[i];
                int rightStringNum = mem[stringLength] - mem[j];
                if (leftStringNum == midStringNum && leftStringNum == rightStringNum) {
                    result++;
                    result %= mod;
                }
            }
        }
        return result;
    }

    /**
     * 一次遍历 复杂度为n
     *
     * @param s
     * @return
     */
    public int numWays2(String s) {
        if (s == null || s.length() < 3) {
            return 0;
        }
        int stringLength = s.length();
        int oneNums = 0;
        for (int i = 0; i < stringLength; i++) {
            if (s.charAt(i) == '1') {
                oneNums++;
            }
        }
        if (oneNums == 0) {
            long zeroWays =  (long) (stringLength-1) * (stringLength -2)/2;
            return (int) (zeroWays % mod);
        }
        // 无法整除3 没有任何方案可以得到这样的结果
        if (oneNums % 3 != 0) {
            return 0;
        }
        // 找到属于左子串的最后一个1的index
        // 找到属于中间子串的第一个1和最后一个1
        // 找到属于右子串的第一个1
        int subStringOneNums = oneNums / 3;
        int leftLastOneIndex = 0;
        int midFirstOneIndex = 0;
        int midLastOneIndex = 0;
        int rightFirstOneIndex = 0;
        long sum = 0;
        for (int i = 0; i < stringLength; i++) {
            if (s.charAt(i) == '1') {
                sum++;
                if (sum == subStringOneNums) {
                    leftLastOneIndex = i;
                }
                if (sum == subStringOneNums + 1) {
                    midFirstOneIndex = i;
                }
                if (sum == subStringOneNums * 2) {
                    midLastOneIndex = i;
                }
                if (sum == subStringOneNums * 2 + 1) {
                    rightFirstOneIndex = i;
                }
            }
        }
        // 左子串最后一个1和中子串第一个1中间的间隔数
        int count1 = midFirstOneIndex - leftLastOneIndex;
        // 中子串最后一个1和右子串第一个1中间的间隔数
        int count2 = rightFirstOneIndex - midLastOneIndex;
        long ways = (long) count1 * count2;
        return (int) (ways % mod);
    }

    public static void main(String[] args) {
        String a = "";
        int result = new LeetCode1573分割字符串的方案数().numWays2(a);
        System.out.println(result);
    }
}
