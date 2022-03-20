package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/19
 */
public class LeetCode1359有效的快递序列数目 {

    /**
     * 结果需要对这个数进行取模
     */
    int mod = 1000000007;

    /**
     * 统计订单
     *
     * @param n
     * @return
     */
    public int countOrders(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 6;
        }
        long pre = 6;
        long result = 6;
        for (int i = 3; i <= n; i++) {
            result = (i * pre % mod * (2L * i - 1)) % mod;
            pre = result;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1359有效的快递序列数目().countOrders(8));
    }
}
