package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/24
 */
public class LeetCode348设计井字棋 {


    /**
     * 井字棋的类
     */
    class TicTacToe {

        public int n;
        public int[][] rowPlayerNum;
        public int[][] colPlayerNum;
        public int[][] diagonalNum;

        public TicTacToe(int n) {
            this.n = n;
            rowPlayerNum = new int[n][2];
            colPlayerNum = new int[n][2];
            // diagonalNum[0]表示从左上到右下的对角线
            // diagonalNum[1]表示从右上到左下的对角线
            diagonalNum = new int[2][2];
        }

        /**
         * 返回1或者2 表示是选手1还是选手2获得了胜利
         * 因为输入保证了正确性 所以只要记录每一行和每一列每个玩家的棋子数量即可
         * 比较棘手的是对角线
         *
         * @param row
         * @param col
         * @param player
         * @return
         */
        public int move(int row, int col, int player) {
            if (++rowPlayerNum[row][player - 1] == n) {
                return player;
            }
            if (++colPlayerNum[col][player - 1] == n) {
                return player;
            }
            if (row == col) {
                if (++diagonalNum[0][player - 1] == n) {
                    return player;
                }
            }
            if (row + col == n - 1) {
                if (++diagonalNum[1][player - 1] == n) {
                    return player;
                }
            }
            return 0;
        }
    }
}
