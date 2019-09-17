package aimToOffer.printMatrix;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author acer
 * @Date 2019/4/15 15:32
 */
public class Solution {
    //给定一个矩形数组 按照从外到内的顺序 顺时针对数组进行打印
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        //横纵坐标的最小值 随着运算逐渐变大
        int row1 = 0;
        int col1 = 0;
        //横纵坐标的最大值 随着运算逐渐变小
        int row2 = matrix.length;
        int col2 = matrix[0].length;
        if (row2 == 0 && col2 == 0)
            return result;
        //开始运算
        while (true) {
            //从左向右进行运算
            for (int i = col1; i < col2; ++i) {
                result.add(matrix[row1][i]);
            }
            //运算完之后需要将横坐标向下移动一格
            ++row1;
            //循环结束条件
            if (row1 >= row2)
                break;


            //从上向下进行运算
            for (int i = row1; i < row2; ++i) {
                result.add(matrix[i][col2-1]);
            }
            //运算完之后需要将纵坐标向左移动一格
            --col2;
            //循环结束条件
            if (col1 >= col2)
                break;


            //从右往左进行运算
            for (int i = col2-1; i >= col1; --i) {
                result.add(matrix[row2-1][i]);
            }
            //运算完之后需要将横坐标向上移动一格
            --row2;
            //循环结束条件
            if (row1 >= row2)
                break;


            //从下往上进行运算
            for (int i = row2-1; i >= row1; --i) {
                result.add(matrix[i][col1]);
            }
            //运算完之后需要将纵坐标向右移动一格
            ++col1;
            if (col1 >= col2)
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print('\n');
        }

        ArrayList<Integer> arrayList = new Solution().printMatrix(matrix);
        System.out.print(arrayList.toString());
    }
}
