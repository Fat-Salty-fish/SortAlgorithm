package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/27
 */
public class AimToOffer12矩阵中的路径 {

    public int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty() || board == null || board.length == 0) {
            return false;
        }
        boolean[][] checked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j, checked)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs(char[][] board, String word, int wordIndex, int x, int y, boolean[][] checked) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || checked[x][y] || word.charAt(wordIndex) != board[x][y]) {
            return false;
        }
        checked[x][y] = true;
        boolean result = false;
        for (int[] dirs : directions) {
            result = dfs(board, word, wordIndex + 1, x + dirs[0], y + dirs[1], checked);
            if (result) {
                return result;
            }
        }
        checked[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] array = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String test = "AAB";
        boolean result = new AimToOffer12矩阵中的路径().exist(array,test);
        System.out.println(result);
    }
}
