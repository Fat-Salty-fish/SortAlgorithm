package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/18
 */
public class LeetCode552学生出勤记录II {

    /**
     * 返回能够领取奖励的方案次数
     * 从题目上来看 这个题可以用回溯法来解决
     * 但是看了一下数量级 n最大为10的5次方 回溯法一定会超时
     * 应该是要用动态规划解决
     * 动态规划解决问题的思路 ：
     * 状态和选择
     * 要求： 总出勤次数中 旷到的次数小于2
     * 连续迟到的次数 小于3
     * 所以状态 总出勤天数 i 旷到次数 j 结尾连续迟到次数 k
     *
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        if (n == 0) {
            return 0;
        }
        // 用三个数组来维护状态
        // 分别维护一个第n天为缺勤/迟到/到场的状态
        // 第n天为缺勤。
        // A 缺勤 L 迟到 P 到场
        int[] A = {0, 0, 0, 0, 0, 0};
        int[] L = {0, 0, 0, 0, 0, 0};
        int[] P = {0, 0, 0, 0, 0, 0};
        // 初始化 第0天 第一个下标表示到今天为止，有多少次旷到
        // 第二个下标表示到今天位置，有连续多少天的迟到
        // 组合运算后计算一维数组的下标
        P[0] = 1;
        A[3] = 1;
        L[1] = 1;
        // 每一天进行处理
        for (int i = 2; i <= n; i++) {
            int[] tempA = {0, 0, 0, 0, 0, 0};
            int[] tempL = {0, 0, 0, 0, 0, 0};
            int[] tempP = {0, 0, 0, 0, 0, 0};

            // 第N天到场并且 0 0
            tempP[0] = (P[0] + L[1] + L[2]) % 1000000007;
            // 第N天到场并且 1 0
            tempP[3] = (P[3] + A[3] + L[4] + L[5]) % 1000000007;

            // 第N天迟到 0 1
            tempL[1] = P[0] % 1000000007;
            // 第N天迟到 0 2
            tempL[2] = L[1] % 1000000007;
            // 第N天迟到 1 1
            tempL[4] = (A[3] + P[3]) % 1000000007;
            // 第N天迟到 1 2
            tempL[5] = L[4] % 1000000007;

            // 第N天旷到 1 0
            tempA[3] = (P[0] + L[1] + L[2]) % 1000000007;


            A = tempA;
            L = tempL;
            P = tempP;
        }

        long result = 0;
        for (int i = 0; i < 6; i++) {
            result = (result + A[i]) % 1000000007;
            result = (result + L[i]) % 1000000007;
            result = (result + P[i]) % 1000000007;
        }
        return (int) result;
    }

    public int checkRecord2(int n) {
        if (n == 0) {
            return 0;
        }

        int P00 = 1, P10 = 0, L01 = 1, L02 = 0, L11 = 0, L12 = 0, A10 = 1;
        for (int i = 2; i <= n; i++) {
            int tempP00 = ((P00 + L01) % 1000000007 + L02) % 1000000007;
            int tempP10 = ((P10 + A10) % 1000000007 + (L11 + L12) % 1000000007) % 1000000007;

            int tempL01 = (P00) % 1000000007;
            int tempL02 = (L01) % 1000000007;
            int tempL11 = (A10 + P10) % 1000000007;
            int tempL12 = (L11) % 1000000007;

            int tempA10 = ((P00 + L01) % 1000000007 + L02) % 1000000007;

            P00 = tempP00;
            P10 = tempP10;
            L01 = tempL01;
            L02 = tempL02;
            L11 = tempL11;
            L12 = tempL12;
            A10 = tempA10;
        }

        int result = ((((((P00 + P10) % 1000000007 + L01) % 1000000007 + L02) % 1000000007 + L11) % 1000000007 + L12) % 1000000007 + A10) % 1000000007;

        return result;
    }

    public static void main(String[] args) {
        int n = 10101;
        int result = new LeetCode552学生出勤记录II().checkRecord2(n);
        System.out.println(result);
    }
}
