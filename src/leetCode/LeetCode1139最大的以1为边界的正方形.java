package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/13
 */
public class LeetCode1139最大的以1为边界的正方形 {

    /**
     * 最大的边界为1的正方形
     * 用dp数组来保存(i,j)位置的右边有多少个连续的1 下边有多少个连续的1
     *
     * @param grid
     * @return
     */
    public int largest1BorderedSquare(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        // 初始化 0数组表示右边 1数组表示下边
        int[][][] mem = new int[grid.length][grid[0].length][2];
        // 最后一行 从右向左
        for (int i = colNum - 1; i >= 0; i--) {
            mem[rowNum - 1][i][0] = grid[rowNum - 1][i] == 0 ? 0 : (1 + (i == colNum - 1 ? 0 : mem[rowNum - 1][i + 1][0]));
            mem[rowNum - 1][i][1] = grid[rowNum - 1][i];
        }
        // 最后一列 从下到上
        for (int i = rowNum - 1; i >= 0; i--) {
            mem[i][colNum - 1][1] = grid[i][colNum - 1] == 0 ? 0 : (1 + (i == rowNum - 1 ? 0 : mem[i + 1][colNum - 1][1]));
            mem[i][colNum - 1][0] = grid[i][colNum - 1];
        }
        // 处理整个矩阵
        for (int i = rowNum - 2; i >= 0; i--) {
            for (int j = colNum - 2; j >= 0; j--) {
                mem[i][j][0] = grid[i][j] == 0 ? 0 : (1 + mem[i][j + 1][0]);
                mem[i][j][1] = grid[i][j] == 0 ? 0 : (1 + mem[i + 1][j][1]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                int minLength = Math.min(rowNum - i, colNum - j);
                max = Math.max(max, maxSquare(i, j, mem, grid, minLength));
            }
        }
        return max * max;
    }

    /**
     * 统计目标长度内的最大矩型面积
     *
     * @param x
     * @param y
     * @param mem
     * @param grid
     * @param minLength
     * @return
     */
    public int maxSquare(int x, int y, int[][][] mem, int[][] grid, int minLength) {
        int result = Integer.MIN_VALUE;
        for (int length = minLength; length >= 1; length--) {
            // 左上角 向右和向下
            int leftUpRight = mem[x][y][0];
            int leftUpDown = mem[x][y][1];
            if (leftUpRight < length || leftUpDown < length) {
                continue;
            }
            // 右上角 向下
            int rightUpDown = mem[x][y + length - 1][1];
            if (rightUpDown < length) {
                continue;
            }
            // 左下角 向右
            int leftDownRight = mem[x + length - 1][y][0];
            if (leftDownRight < length) {
                continue;
            }
            // 跑到这里其实已经能算出来这个位置的最大正方形了 不用再计算了
            result = length;
            break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 0}};
        int result = new LeetCode1139最大的以1为边界的正方形().largest1BorderedSquare(grid);
        System.out.println(result);
    }
}
