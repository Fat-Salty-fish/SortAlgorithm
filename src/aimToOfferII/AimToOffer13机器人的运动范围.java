package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/27
 */
public class AimToOffer13机器人的运动范围 {

    /**
     * 方向
     */
    public int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};


    /**
     * 还是dfs
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        return dfs(m,n,k,0,0,visited);
    }

    public int dfs(int m, int n, int k, int x, int y, boolean[][] visited) {
        if (x < 0 || x == m || y < 0 || y == n || visited[x][y] || !check(x, y, k)) {
            return 0;
        }
        visited[x][y] = true;
        int result = 1;
        for (int[] dir : directions) {
            result += dfs(m, n, k, x + dir[0], y + dir[1], visited);
        }
        return result;
    }

    /**
     * 检查坐标是否符合要求
     *
     * @param x
     * @param y
     * @param k
     * @return
     */
    public boolean check(int x, int y, int k) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}
