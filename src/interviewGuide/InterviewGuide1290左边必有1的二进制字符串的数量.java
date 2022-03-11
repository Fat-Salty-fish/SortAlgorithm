package interviewGuide;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/6
 */
public class InterviewGuide1290左边必有1的二进制字符串的数量 {

    /**
     * 寻找规律 类似于斐波那契数列
     *
     * @param n
     * @return
     */
    public int getNum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int n1 = 1;
        int n2 = 2;
        int result = 0;
        int mod = (int) Math.pow(2, 29);
        for (int temp = 3; temp <= n; temp++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
