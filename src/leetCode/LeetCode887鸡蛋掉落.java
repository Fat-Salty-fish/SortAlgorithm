package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/9
 */
public class LeetCode887鸡蛋掉落 {

    /**
     * 假设存在f  0<=f<=n 此f表示高于f层上扔下鸡蛋时都会被摔碎
     * 求最少扔多少次 能验证出来f的值
     * <p>
     * 状态：当前剩余鸡蛋数 k
     * 高楼层数 n
     * dp数组能知道什么？dp[k][n]表示剩余k个鸡蛋并要验证高楼层数为n时 所需最少的掉落次数
     * base case 最差情况下 dp[1][n] = n 因为用一个鸡蛋 从下往上 逐步测试 直到验证出来
     * dp[0][n] = 0 没有鸡蛋的情况下无法验证
     * 鸡蛋如果更多 应该如何验证？二分查找？
     *
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        if (k == 0 || n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        // 行表示有i个鸡蛋的情况下 列表示当有j层楼时
        int[][] dp = new int[k + 1][n + 1];
        // 初始化 鸡蛋个数为0时 不论多少层楼 实验次数都为0次
        // 鸡蛋个数为1时 不论多少层楼 实验次数都等于楼层高度
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        // 楼层数为0时 不论有多少个鸡蛋 实验次数都为0次
        // 楼层数为1时 不论有多少个鸡蛋 实验次数都为1次
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }
        // 从第2行 第2列开始计算
        // i表示鸡蛋个数 j表示楼层数 k表示当前楼层数
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = 9999;
                for (int m = 1; m <= j; m++) {
                    // 没碎 dp[i][j-m]继续求解 碎了 dp[i-1][m-1]求解
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][j - m], dp[i - 1][m - 1]) + 1);
                }
            }
        }
        return dp[k][n];
    }

    /**
     * 二分查找代替线性查找
     *
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop2(int k, int n) {
        if (k == 0 || n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        // 行表示有i个鸡蛋的情况下 列表示当有j层楼时
        int[][] dp = new int[k + 1][n + 1];
        // 初始化 鸡蛋个数为0时 不论多少层楼 实验次数都为0次
        // 鸡蛋个数为1时 不论多少层楼 实验次数都等于楼层高度
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        // 楼层数为0时 不论有多少个鸡蛋 实验次数都为0次
        // 楼层数为1时 不论有多少个鸡蛋 实验次数都为1次
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }
        // 从第2行 第2列开始计算
        // i表示鸡蛋个数 j表示楼层数 k表示当前楼层数
        // dp 当k固定时 dp是根据n单调递增的
        // 所以 在测试第k层时 时 鸡蛋碎了 broken = dp[i-1][k-1]
        // 鸡蛋没碎 notBroken = dp[i][j-k]
        // broken根据k单调递增
        // notBroken 根据k单调递减
        // 这两个函数的最小值 就是一次查询的结果 使用二分法
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = 9999;
                int left = 1;
                int right = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int broken = dp[i - 1][mid - 1];
                    int notBroken = dp[i][j - mid];
                    // 代替Math.max方法
                    if (broken > notBroken) {
                        right = mid - 1;
                        dp[i][j] = Math.min(broken + 1, dp[i][j]);
                    } else {
                        left = mid;
                        dp[i][j] = Math.min(notBroken + 1, dp[i][j]);
                    }
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        int result = new LeetCode887鸡蛋掉落().superEggDrop2(2, 6);
    }
}
