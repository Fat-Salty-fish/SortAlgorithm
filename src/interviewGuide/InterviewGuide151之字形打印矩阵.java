package interviewGuide;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/11
 */
public class InterviewGuide151之字形打印矩阵 {

    /**
     * 之字形打印数组
     *
     * @param matrix
     * @return
     */
    public List<Integer> printMatrix(int[][] matrix) {
        int upLeft = 0;
        int upRight = 0;
        int downLeft = 0;
        int downRight = 0;
        List<Integer> result = new ArrayList<>();
        boolean upToDown = false;
        while (upLeft < matrix.length && upRight < matrix[0].length) {
            print(result, matrix, upLeft, upRight, downLeft, downRight, upToDown);
            upToDown = !upToDown;
            upLeft = upRight == matrix[0].length - 1 ? upLeft + 1 : upLeft;
            upRight = upLeft == 0 ? upRight + 1 : upRight;
            downRight = downLeft == matrix.length - 1 ? downRight + 1 : downRight;
            downLeft = downLeft == matrix.length - 1 ? downLeft : downLeft + 1;
        }
        return result;
    }

    /**
     * 打印斜线
     *
     * @param result
     * @param matrix
     * @param upLeft
     * @param upRight
     * @param downLeft
     * @param downRight
     * @param upToDown
     */
    public void print(List<Integer> result, int[][] matrix, int upLeft, int upRight, int downLeft, int downRight, boolean upToDown) {
        if (upToDown) {
            int currentRow = upLeft;
            int currentCol = upRight;
            while (currentRow <= downLeft && currentCol >= downRight) {
                result.add(matrix[currentRow++][currentCol--]);
            }
        } else {
            int currentRow = downLeft;
            int currentCol = downRight;
            while (currentRow >= upLeft && currentCol <= upRight) {
                result.add(matrix[currentRow--][currentCol++]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> result = new InterviewGuide151之字形打印矩阵().printMatrix(matrix);
        for (int temp : result) {
            System.out.println(temp);
        }
    }
}
