package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/10/28
 */
public class LeetCode361轰炸敌人 {

    /**
     * 轰炸敌人
     *
     * @param grid
     * @return
     */
    public int maxKilledEnemies(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // 需要记录四个二维数组 来保存上下左右4个位置的信息
        // dp[i][j] 表示在此位置放置炸弹的话 可以在四个方向上炸到多少个敌人
        int[][] dpUp = new int[row][col];
        int[][] dpDown = new int[row][col];
        int[][] dpLeft = new int[row][col];
        int[][] dpRight = new int[row][col];
        // 先从左往右 从上到下遍历 记录dpUp 和dpLeft
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char current = grid[i][j];
                if (current == 'W') {
                    // 这一格是墙
                    dpUp[i][j] = 0;
                    dpLeft[i][j] = 0;
                } else if (current == 'E') {
                    // 这一格是敌人 可以被炸死消灭 但是无法放置炸弹
                    dpUp[i][j] = i - 1 >= 0 ? dpUp[i - 1][j] + 1 : 1;
                    dpLeft[i][j] = j - 1 >= 0 ? dpLeft[i][j - 1] + 1 : 1;
                } else {
                    dpUp[i][j] = i - 1 >= 0 ? dpUp[i - 1][j] : 0;
                    dpLeft[i][j] = j - 1 >= 0 ? dpLeft[i][j - 1] : 0;
                }
            }
        }
        // 从右往左 从下到上遍历 记录dpRight 和 dpDown
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                char current = grid[i][j];
                if (current == 'W') {
                    // 这一格是墙
                    dpDown[i][j] = 0;
                    dpRight[i][j] = 0;
                } else if (current == 'E') {
                    // 这一格是敌人 可以被炸死消灭 但是无法放置炸弹
                    dpDown[i][j] = i + 1 < row ? dpDown[i + 1][j] + 1 : 1;
                    dpRight[i][j] = j + 1 < col ? dpRight[i][j + 1] + 1 : 1;
                } else {
                    dpDown[i][j] = i + 1 < row ? dpDown[i + 1][j] : 0;
                    dpRight[i][j] = j + 1 < col ? dpRight[i][j + 1] : 0;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char current = grid[i][j];
                // 不能放置炸弹
                if (current == 'W' || current == 'E') {
                    continue;
                }
                int up = i - 1 >= 0 ? dpUp[i - 1][j] : 0;
                int down = i + 1 < row ? dpDown[i + 1][j] : 0;
                int left = j - 1 >= 0 ? dpLeft[i][j - 1] : 0;
                int right = j + 1 < col ? dpRight[i][j + 1] : 0;
                int killEnemy = up + down + left + right;
                result = Math.max(result, killEnemy);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        char[][] chars = new char[][]{{'0'}, {'0'}, {'0'}};
        int result = new LeetCode361轰炸敌人().maxKilledEnemies(chars);
    }
}
