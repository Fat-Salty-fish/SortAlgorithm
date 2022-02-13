package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/10
 */
public class LeetCode1074元素和为目标值的子矩阵数量 {

    /**
     * 第三题 矩阵数组和
     * 感觉不是dfs就是bfs
     *
     * @param matrix
     * @param target
     * @return
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int result = 0;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        for (int i = 0; i < rowNum; i++) {
            int[] sum = new int[colNum];
            for (int j = i; j < rowNum; j++) {
                for (int k = 0; k < colNum; k++) {
                    sum[k] += matrix[j][k];
                }
                result += sumOfTargetK(sum, target);
            }
        }
        return result;
    }

    public int sumOfTargetK(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] pre = new int[array.length];
        pre[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            pre[i] = pre[i - 1] + array[i];
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += map.getOrDefault(pre[i] - k, 0);
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, -1}, {-1, 1}};
        int target = 0;
        int result = new LeetCode1074元素和为目标值的子矩阵数量().numSubmatrixSumTarget(matrix, target);
    }

}
