package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/1/21
 */
public class LeetCode100188按距离统计房屋对数目I {


    public int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];
        int[][] minPath = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            minPath[i] = new int[n + 1];
        }

        int infi = Integer.MAX_VALUE / 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    minPath[i][j] = 0;
                } else {
                    minPath[i][j] = infi;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            minPath[i][i + 1] = 1;
            minPath[i + 1][i] = 1;
        }
        if (x != y) {
            minPath[x][y] = 1;
            minPath[y][x] = 1;
        }

        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    minPath[i][j] = Math.min(minPath[i][j], minPath[i][p] + minPath[p][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (minPath[i][j] == 0 || minPath[i][j] == infi) {
                    continue;
                }
                result[minPath[i][j] - 1]++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new LeetCode100188按距离统计房屋对数目I().countOfPairs(3,1,3);
    }
}
