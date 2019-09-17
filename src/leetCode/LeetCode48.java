package leetCode;

/**
 * @author acer
 * @Date 2019/8/26 16:53
 */
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        //
        int length = matrix.length;
        for (int i = 0; i < (length+1)/2; i++) {
            for (int j = 0; j < length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j -1][i];
                matrix[length-j-1][i] = matrix[length-i-1][length-j-1];
                matrix[length-i-1][length-j-1] = matrix[j][length-i-1];
                matrix[j][length-i-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode48().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
