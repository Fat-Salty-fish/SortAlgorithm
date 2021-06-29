package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/5/8
 */
public class LeetCode79单词搜索 {

    /**
     * 单词搜索 回溯算法
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int[][] mark = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean existed = existBack(board, word, i, j, 0, mark);
                if (existed) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 回溯方法
     *
     * @param board
     * @param word
     * @param i     当前board的行号
     * @param j     当前board的列号
     * @param mark 用来标识当前字符是否已经使用过了 若使用过则不能继续前进
     * @return
     */
    public boolean existBack(char[][] board, String word, int i, int j, int index, int[][] mark) {
        // 第board[i][j]已经被标记了 直接返回false
        if (mark[i][j] == 1) {
            return false;
        }
        mark[i][j] = 1;
        char currentChar = word.charAt(index);
        // 如果走到了最后一个字符 并且当前board的字符就是最后一个字符 则说明存在字符串
        if (word.length() == index + 1 && board[i][j] == currentChar) {
            return true;
            // 如果不是最后一个字符 但是当前字符符合 则需要向上下左右遍历
        } else if (board[i][j] == currentChar) {
            boolean up = false;
            boolean down = false;
            boolean left = false;
            boolean right = false;
            // 上
            if (i > 0) {
                up = existBack(board, word, i - 1, j, index + 1, mark);
            }
            // 下
            if (i + 1 < board.length) {
                down = existBack(board, word, i + 1, j, index + 1, mark);
            }
            // 左
            if (j > 0) {
                left = existBack(board, word, i, j - 1, index + 1, mark);
            }
            // 右
            if (j + 1 < board[0].length) {
                right = existBack(board, word, i, j + 1, index + 1, mark);
            }
            mark[i][j] = 0;
            return up || down || left || right;
        }
        mark[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String str = "ABCCED";
        boolean result = new LeetCode79单词搜索().exist(chars, str);
        System.out.println("结果" + result);
    }
}
