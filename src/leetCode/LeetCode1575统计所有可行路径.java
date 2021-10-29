package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/10/5
 */
public class LeetCode1575统计所有可行路径 {


    int mod = 1000000007;

    /**
     * 记忆化数组
     * 表示起点在i 有j格油的情况下的路径条数
     */
    public int[][] mem;

    /**
     * 动态规划特训
     * 首先 记忆化+dfs
     *
     * @param locations
     * @param start
     * @param finish
     * @param fuel
     * @return
     */
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        mem = new int[locations.length][fuel + 1];
        // 标记这一格是否已经被处理 -1表示未处理
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(mem[i], -1);
        }
        return dfs(locations, start, finish, fuel);
    }

    /**
     * dfs遍历
     *
     * @param locations
     * @param currentLocation
     * @param finish
     * @param fuel
     * @return
     */
    public int dfs(int[] locations, int currentLocation, int finish, int fuel) {
        if (mem[currentLocation][fuel] != -1) {
            return mem[currentLocation][fuel];
        }

        // base case 有两个 一是如果没有油了(fuel==0)并且此时的位置不在目标位置 则返回0
        if (fuel == 0 && currentLocation != finish) {
            mem[currentLocation][fuel] = 0;
            return 0;
        }
        // 二是如果此时无法直接到达目的地 则无论如何移动都无法到达目的地
        int directNeed = locations[finish] - locations[currentLocation];
        if (directNeed > fuel) {
            mem[currentLocation][fuel] = 0;
            return 0;
        }
        int sum = currentLocation == finish ? 1 : 0;

        // 处理dfs
        for (int i = 0; i < locations.length; i++) {
            if (i != currentLocation) {
                int need = Math.abs(locations[currentLocation] - locations[i]);
                if (fuel >= need) {
                    sum += dfs(locations, i, finish, fuel - need);
                    sum %= mod;
                }
            }
        }
        mem[currentLocation][fuel] = sum;
        return sum;
    }

    /**
     * 动态规划特训
     * 从dfs优化到dp
     * dp定义 从i位置j油量的情况下 到达目的地的方法数
     * 状态转移方程
     * dp[i][j] = dp[i][j] + dp[m][fuel - n]
     *
     * @param locations
     * @param start
     * @param finish
     * @param fuel
     * @return
     */
    public int countRoutes2(int[] locations, int start, int finish, int fuel) {
        int locationNum = locations.length;
        int[][] dp = new int[locationNum][fuel + 1];
        // 当前位置就在finish时 就是一种方法 base case
        for (int i = 0; i <= fuel; i++) {
            dp[finish][i] = 1;
        }
        // dp遍历方向应该如何注意？ 为什么必须先遍历fuel？
        // 如果先遍历location 则某些location下的小fuel并没有计算过 得出的结果有误
        for (int j = 0; j <= fuel; j++) {
            for (int i = 0; i < locationNum; i++) {
                // 从当前位置出发 当前油量下 能去到所有的位置都算一个方法
                for (int m = 0; m < locationNum; m++) {
                    if (m == i) {
                        continue;
                    }
                    int need = Math.abs(locations[m] - locations[i]);
                    if (need <= j) {
                        dp[i][j] += dp[m][j - need];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return dp[start][fuel];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 8, 4};
        int a = 1;
        int b = 3;
        int c = 5;
        int result = new LeetCode1575统计所有可行路径().countRoutes2(nums, a, b, c);
        System.out.println("结果为" + result);
    }
}
