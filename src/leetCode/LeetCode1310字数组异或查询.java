package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/5/12
 */
public class LeetCode1310字数组异或查询 {
    /**
     * 第一次做 直接暴力一点
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] range = queries[i];
            int left = range[0];
            int right = range[1];
            if (left == right){
                result[i] = arr[left];
                continue;
            }
            int temp = 0;
            for (int j = left; j <= right;i++){
                temp ^= arr[j];
            }
            result[i] = temp;
        }
        return result;
    }

    /**
     * 因为第一次暴力求解没解出来 所以得优化算法
     * 使用前缀异或
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries2(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        // 修改原数组 从index=1开始 异或之前的值
        // 得arr[i] 为arr[0]->arr[i]的所有异或值
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }
        // 再处理queries计算结果即可
        for (int i = 0; i < queries.length; i++) {
            result[i] = arr[queries[i][1]] ^ (queries[i][0] == 0 ? 0 : arr[queries[i][0] - 1]);
        }
        return result;
    }
}
