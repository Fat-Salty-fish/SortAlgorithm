package leetCode;

/**
 * @author acer
 * @Date 2019/7/25 15:33
 */
public class LeetCode70爬楼梯 {
    //    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//注意：给定 n 是一个正整数。
//
//示例 1：
//
//输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//示例 2：
//
//输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int i = 3;
            int[] array = new int[n + 1];
//            array[1]=1;
            int temp1 = 1;
            int temp2 = 2;
//            array[2]=2;
            int ans = 0;
            while (i <= n) {
//                array[i] = array[i-1]+array[i-2];
//                i++;
                ans = temp1 + temp2;
                temp1 = temp2;
                temp2 = ans;
                i++;
            }
            return ans;
        }
    }

    /**
     * 三刷爬楼梯
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // 定义dp[n] 意为爬n阶楼梯时 有dp[n]种方法 取值范围 0<=i<=n
        int[] dp = new int[n + 1];
        // 初始化dp
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 每到一个阶梯总有两种方法 即一步上来或者两步上来 dp[i] = dp[i-1]+dp[i-2]
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 缩减dp规模
     *
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int num1 = 1;
        int num2 = 2;
        int result = num1 + num2;
        for (int i = 3; i <= n; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }

    /**
     * 动态规划特训 5刷
     *
     * @param n
     * @return
     */
    public int climbStairs5(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int result = second;
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode70爬楼梯().climbStairs2(5));
    }
}
