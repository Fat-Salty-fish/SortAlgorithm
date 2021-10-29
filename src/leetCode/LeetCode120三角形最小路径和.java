package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/19
 */
public class LeetCode120三角形最小路径和 {


    /**
     * 三角形最小路径和
     * 动态规划
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        // 定义dp[i][j] 表示取前i行(从0开始) 结尾位置为j时 路径和为dp[i][j] 其中i的取值范围是  0<=i<triangle.size() j的取值范围是 0<=j<triangle.get(i-1).length
        // 实际上 最后一行的行size就是n 所以 0<=i<triangle.size 0<=j<triangle.size
        int[][] dp = new int[triangle.size()][triangle.size()];
        // 其实每一行 j的最大值都为i 初始化
        dp[0][0] = triangle.get(0).get(0);
        // 从第二行开始计算
        // 看看能否压缩成一维数组
        for (int i = 1; i < n; i++) {
            List<Integer> rowNum = triangle.get(i);
            dp[i][0] = rowNum.get(0) + dp[i - 1][0];
            for (int j = 1; j < rowNum.size(); j++) {
                int currentNum = rowNum.get(j);
                int min = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                dp[i][j] = min + currentNum;
            }
            dp[i][rowNum.size() - 1] = rowNum.get(rowNum.size() - 1) + dp[i - 1][rowNum.size() - 2];
        }
        int min = Integer.MAX_VALUE;
        // 寻找最小的数
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

    /**
     * 二刷三角形最小路径和
     * 二维dp数组简化为一维
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        // 一维数组
        // 能否压缩为一维数组？ 考虑如何计算新的一行的值 此行的第一位 只能由上一行的第一位计算得来
        // 此行的最后一位 只能由上一行的最后一位计算得来 所以应该从此行的最后一位来计算
        // 取值范围 0<=i<n-1
        int[] dp = new int[n];
        // 初始化
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> currentList = triangle.get(i);
            int currentSize = currentList.size();
            dp[currentSize - 1] = dp[currentSize - 2] + currentList.get(currentSize - 1);
            for (int j = currentSize - 2; j >= 1; j--) {
                int min = Math.min(dp[j], dp[j - 1]);
                dp[j] = min + currentList.get(j);
            }
            dp[0] = dp[0] + currentList.get(0);
        }

        int min = Integer.MAX_VALUE;
        // 寻找最小的数
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    /**
     * 三刷三角形最短路径 从底向上
     * 从底向上 不需要在运算一遍
     *
     * @param triangle 三角形
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        // 从底向上 一维数组dp
        int[] dp = new int[n];
        List<Integer> finalRow = triangle.get(n - 1);
        // 初始化dp
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = finalRow.get(i);
        }
        // dp处理
        for (int i = triangle.size() - 2; i >= 0; i--) {
            // 从倒数第二行开始处理 所以不需要担心数组越界的问题
            List<Integer> rowNums = triangle.get(i);
            int rowSize = rowNums.size();
            for (int j = 0; j < rowSize; j++) {
                dp[j] = rowNums.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    /**
     * 四刷
     *
     * @param triangle
     * @return
     */
    public int minimumTotal4(List<List<Integer>> triangle) {
        int rowNum = triangle.size();
        int[][] dp = new int[rowNum][rowNum];
        // 如果正着来 需要处理当前元素的上一行当前列没有值时的情况
        // 倒着来就没有这个问题 并且可以不用再循环一次 base case 最后一行
        for (int i = 0; i < rowNum; i++) {
            dp[0][i] = triangle.get(rowNum - 1).get(i);
        }
        // 倒着来 从倒数第二行开始
        for (int i = 1; i < rowNum; i++) {
            List<Integer> currentRow = triangle.get(rowNum - i - 1);
            for (int j = 0; j < currentRow.size(); j++) {
                int currentNum = currentRow.get(j);
                int min = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                dp[i][j] = currentNum + min;
            }
        }
        return dp[rowNum - 1][0];
    }


    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        List<List<Integer>> question = new ArrayList<>();
        question.add(row1);
        question.add(row2);
        question.add(row3);
        question.add(row4);
        int result = new LeetCode120三角形最小路径和().minimumTotal4(question);
        System.out.println(result);
    }
}
