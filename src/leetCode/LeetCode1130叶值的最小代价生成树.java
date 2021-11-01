package leetCode;

import java.util.Stack;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/10/29
 */
public class LeetCode1130叶值的最小代价生成树 {

    /**
     * 动态规划特训
     * 区间dp
     * 复杂度n的三次方 后续尝试单调栈方法
     *
     * @param arr
     * @return
     */
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return 0;
        }
        if (arr.length == 2) {
            return arr[0] * arr[1];
        }
        int arrLength = arr.length;
        // 用来记录(arr[i],arr[j])之间的最大数
        int[][] maxValue = new int[arrLength][arrLength];
        for (int i = 0; i < arrLength; i++) {
            maxValue[i][i] = arr[i];
            for (int j = i + 1; j < arrLength; j++) {
                maxValue[i][j] = Math.max(maxValue[i][j - 1], arr[j]);
            }
        }
        //用来记录(ar[i],arr[j])之间的结果值
        int[][] dp = new int[arrLength][arrLength];
        for (int i = arrLength - 2; i >= 0; i--) {
            for (int j = i + 1; j < arrLength; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int leftMax = maxValue[i][k];
                    int rightMax = maxValue[k + 1][j];
                    int leftSum = dp[i][k];
                    int rightSum = dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], leftMax * rightMax + leftSum + rightSum);
                }
            }
        }
        return dp[0][arrLength - 1];
    }

    /**
     * 单调栈解决
     *
     * @param arr
     * @return
     */
    public int mctFromLeafValues2(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return 0;
        }
        if (arr.length == 2) {
            return arr[0] * arr[1];
        }
        Integer arrLength = arr.length;
        Stack<Integer> singleStack = new Stack<>();
        singleStack.push(Integer.MAX_VALUE);
        int result = 0;
        for (int i = 0; i < arrLength; i++) {
            int currentNum = arr[i];
            while (currentNum > singleStack.peek()) {
                // 此时一定需要pop一个值了
                int pop = singleStack.pop();
                result += pop * Math.min(currentNum, singleStack.peek());
            }
            singleStack.push(currentNum);
        }
        while (singleStack.size() > 2){
            int pop = singleStack.pop();
            result += pop * singleStack.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 9, 6, 15, 15};
        int result = new LeetCode1130叶值的最小代价生成树().mctFromLeafValues2(array);
        System.out.println(result);
    }
}
