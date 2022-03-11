package leetCode;

/**
 * @author acer
 * @Date 2019/8/26 16:53
 */
public class LeetCode48旋转图像 {
    public void rotate(int[][] matrix) {
        //
        int length = matrix.length;
        for (int i = 0; i < (length + 1) / 2; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;
            }
        }
    }

    /**
     * 二刷
     * 旋转正方形
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int topRow = 0;
        int topCol = 0;
        int bottomRow = matrix.length - 1;
        int bottomCol = matrix[0].length - 1;
        while (topRow <= bottomRow && topCol <= bottomCol) {
            change2(matrix, topRow, topCol, bottomRow, bottomCol);
            topRow++;
            topCol++;
            bottomRow--;
            bottomCol--;
        }
    }

    /**
     * 旋转正方形的边
     * 因为是正方形 所以只有一行/一列时 无须转动
     *
     * @param matrix
     * @param topRow
     * @param topCol
     * @param bottomRow
     * @param bottomCol
     */
    public void change(int[][] matrix, int topRow, int topCol, int bottomRow, int bottomCol) {
        if (topRow == bottomRow) {
            return;
        }
        int temp1 = matrix[topRow][topCol];
        int temp2 = matrix[topRow][bottomCol];
        int temp3 = matrix[bottomRow][bottomCol];
        int temp4 = matrix[bottomRow][topCol];
        matrix[topRow][topCol] = temp4;
        matrix[topRow][bottomCol] = temp1;
        matrix[bottomRow][bottomCol] = temp2;
        matrix[bottomRow][topCol] = temp3;
        int midSize = bottomCol - topCol - 1;
        if (midSize <= 0) {
            return;
        }
        int[] midArray1 = new int[midSize];
        int[] midArray2 = new int[midSize];
        int[] midArray3 = new int[midSize];
        int[] midArray4 = new int[midSize];
        int index = 0;
        for (int i = topCol + 1; i <= bottomCol - 1; i++) {
            midArray1[index++] = matrix[topRow][i];
        }
        index = 0;
        for (int i = topRow + 1; i <= bottomRow - 1; i++) {
            midArray2[index++] = matrix[i][bottomCol];
        }
        index = 0;
        for (int i = bottomCol - 1; i >= topCol + 1; i--) {
            midArray3[index++] = matrix[bottomRow][i];
        }
        index = 0;
        for (int i = bottomRow - 1; i >= topRow + 1; i--) {
            midArray4[index++] = matrix[i][topCol];
        }

        index = 0;
        for (int i = topCol + 1; i <= bottomCol - 1; i++) {
            matrix[topRow][i] = midArray4[index++];
        }
        index = 0;
        for (int i = topRow + 1; i <= bottomRow - 1; i++) {
            matrix[i][bottomCol] = midArray1[index++];
        }
        index = 0;
        for (int i = bottomCol - 1; i >= topCol + 1; i--) {
            matrix[bottomRow][i] = midArray2[index++];
        }
        index = 0;
        for (int i = bottomRow - 1; i >= topRow + 1; i--) {
            matrix[i][topCol] = midArray3[index++];
        }
    }

    /**
     * 原来有更简便的办法...
     * 把每个要交换的数字看作一组
     *
     * @param matrix
     * @param topRow
     * @param topCol
     * @param bottomRow
     * @param bottomCol
     */
    public void change2(int[][] matrix, int topRow, int topCol, int bottomRow, int bottomCol) {
        int times = bottomCol - topCol;
        for (int i = 0; i < times; i++) {
            int temp = matrix[topRow][topCol + i];
            matrix[topRow][topCol + i] = matrix[bottomRow - i][topCol];
            matrix[bottomRow - i][topCol] = matrix[bottomRow][bottomCol - i];
            matrix[bottomRow][bottomCol-i] = matrix[topRow+i][bottomCol];
            matrix[topRow+i][bottomCol] = temp;
        }
    }


    public static void main(String[] args) {
        new LeetCode48旋转图像().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
