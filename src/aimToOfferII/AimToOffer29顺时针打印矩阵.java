package aimToOfferII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/31
 */
public class AimToOffer29顺时针打印矩阵 {


    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[0];
        }
        List<Integer> resultList = new ArrayList<>();
        int leftX = 0;
        int leftY = 0;
        int rightX = matrix.length - 1;
        int rightY = matrix[0].length - 1;
        while (leftX <= rightX && leftY <= rightY) {
            print(matrix, leftX, leftY, rightX, rightY, resultList);
            leftX++;
            leftY++;
            rightX--;
            rightY--;
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    /**
     * 打印矩阵 知道左上角的坐标和右下角的坐标后打印
     *
     * @param matrix
     * @param leftX
     * @param leftY
     * @param rightX
     * @param rightY
     * @param resultList
     */
    public void print(int[][] matrix, int leftX, int leftY, int rightX, int rightY, List<Integer> resultList) {
        // 只有一行
        if (leftX == rightX) {
            for (int i = leftY; i <= rightY; i++) {
                resultList.add(matrix[leftX][i]);
            }
            return;
        }
        // 只有一列
        if (leftY == rightY) {
            for (int i = leftX; i <= rightX; i++) {
                resultList.add(matrix[i][leftY]);
            }
            return;
        }
        // 上边
        int currentX = leftX;
        int currentY = leftY;
        while (currentY <= rightY) {
            resultList.add(matrix[currentX][currentY++]);
        }
        currentY = rightY;
        currentX++;
        // 右边
        while (currentX <= rightX) {
            resultList.add(matrix[currentX++][currentY]);
        }
        currentX = rightX;
        currentY--;
        // 下边
        while (currentY >= leftY) {
            resultList.add(matrix[currentX][currentY--]);
        }
        currentY = leftY;
        currentX--;
        // 左边
        while (currentX > leftX) {
            resultList.add(matrix[currentX--][currentY]);
        }
    }
}
