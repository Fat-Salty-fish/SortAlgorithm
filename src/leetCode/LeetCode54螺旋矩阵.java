package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/10 17:38
 */
public class LeetCode54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int size = m * n;
        int current = 0;
        while (current < size) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
                current++;
            }
            if (current == size) {
                break;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
                current++;
            }
            if (current == size) {
                break;
            }
            right--;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
                current++;
            }
            if (current == size) {
                break;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
                current++;
            }
            if (current == size) {
                break;
            }
            left++;
        }
        return ans;
    }

    /**
     * 二刷
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
        int topRow = 0;
        int topCol = 0;
        int bottomRow = matrix.length - 1;
        int bottomCol = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while (topRow <= bottomRow && topCol <= bottomCol) {
            print(result, matrix, topRow, topCol, bottomRow, bottomCol);
            topRow++;
            topCol++;
            bottomCol--;
            bottomRow--;
        }
        return result;
    }

    /**
     * 打印以(topRow,topCol)到(bottomRow,bottomCol)之间的矩阵外层
     *
     * @param result
     * @param matrix
     * @param topRow
     * @param topCol
     * @param bottomRow
     * @param bottomCol
     */
    public void print(List<Integer> result, int[][] matrix, int topRow, int topCol, int bottomRow, int bottomCol) {
        int currentRow = topRow;
        int currentCol = topCol;
        if (topRow == bottomRow){
            for (int i = topCol;i<=bottomCol;i++){
                result.add(matrix[topRow][i]);
            }
            return;
        }
        if (topCol == bottomCol){
            for (int i = topRow;i<=bottomRow;i++){
                result.add(matrix[i][topCol]);
            }
            return;
        }
        // 从左到右（上边
        while (currentCol <= bottomCol) {
            result.add(matrix[currentRow][currentCol++]);
        }
        currentCol = bottomCol;
        currentRow++;
        // 从上到下（右边
        while (currentRow <= bottomRow) {
            result.add(matrix[currentRow++][currentCol]);
        }
        currentRow = bottomRow;
        currentCol--;
        // 从右到左（下边
        while (currentCol >= topCol) {
            result.add(matrix[currentRow][currentCol--]);
        }
        currentCol = topCol;
        currentRow --;
        // 从下到上（左边
        while (currentRow > topRow) {
            result.add(matrix[currentRow--][currentCol]);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LeetCode54螺旋矩阵().spiralOrder2(new int[][]{{6, 9, 7}});
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
