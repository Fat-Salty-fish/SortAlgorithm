package leetCode;

import java.util.TreeSet;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/10
 */
public class LeetCode363矩形区域不超过K的最大数值和 {

    /**
     * 二维前缀和
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rowNums = matrix.length;
        int colNums = matrix[0].length;
        int max = Integer.MIN_VALUE / 2;
        for (int i = 0; i < rowNums; i++) {
            int[] sum = new int[colNums];
            for (int j = i; j < rowNums; j++) {
                for (int right = 0; right < colNums; right++) {
                    sum[right] += matrix[j][right];
                }
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                // 前缀和
                int sumLeftToRight = 0;
                for (Integer colSum : sum) {
                    sumLeftToRight += colSum;
                    Integer ceil = treeSet.ceiling(sumLeftToRight - k);
                    if (ceil != null) {
                        max = Math.max(max, sumLeftToRight - ceil);
                    }
                    treeSet.add(sumLeftToRight);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 2, -1}};
        int result = new LeetCode363矩形区域不超过K的最大数值和().maxSumSubmatrix(matrix, 3);

    }
}
