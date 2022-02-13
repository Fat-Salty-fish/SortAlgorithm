package codingInterview;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/11
 */
public class CodingInterview1724最大子矩阵 {

    /**
     * 二维状态下的连续子数组的最大和
     * 先从i-j行加起来 再向右就变成了一维状态下的连续子数组的最大和
     * @param matrix
     * @return
     */
    public int[] getMaxMatrix(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int max = Integer.MIN_VALUE / 2;
        int[] result = new int[4];
        int dp = 0;
        int start = 0;
        for (int i = 0; i < rowNum; i++) {
            int[] sum = new int[colNum];
            for (int j = i; j < rowNum; j++) {
                dp = 0;
                start = 0;
                for (int k = 0; k < colNum; k++) {
                    sum[k] += matrix[j][k];
                    if (dp < 0) {
                        dp = sum[k];
                        start = k;
                    } else {
                        dp += sum[k];
                    }
                    if (dp > max) {
                        max = dp;
                        result[0] = i;
                        result[1] = start;
                        result[2] = j;
                        result[3] = k;
                    }
                }
            }
        }
        return result;
    }


}
