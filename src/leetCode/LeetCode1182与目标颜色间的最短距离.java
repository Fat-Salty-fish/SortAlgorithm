package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/27
 */
public class LeetCode1182与目标颜色间的最短距离 {

    /**
     * 动态规划特训
     * 线性查找 会超出时间限制
     *
     * @param colors
     * @param queries
     * @return
     */
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int colorNum = colors.length;
        // 定义dp[i][j] 表示第i个colors 离三个颜色最近的颜色的距离 如果没有则为-1
        int[][] dp = new int[colorNum][4];
        for (int i = 0; i < colorNum; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < colorNum; i++) {
            for (int j = 0; j < colorNum; j++) {
                int colorOfJ = colors[j];
                dp[i][colorOfJ] = Math.min(dp[i][colorOfJ], Math.abs(j - i));
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int targetColor = queries[i][1];
            int result = dp[startIndex][targetColor];
            if (result == Integer.MAX_VALUE) {
                result = -1;
            }
            resultList.add(result);
        }
        return resultList;
    }

    /**
     * 第一种方法超时了 第一种方法的时间复杂度是n的平方 如何缩短时间复杂度？
     *
     * @param colors
     * @param queries
     * @return
     */
    public List<Integer> shortestDistanceColor2(int[] colors, int[][] queries) {
        int colorNum = colors.length;
        int[][] leftDp = new int[colorNum][4];
        int[][] rightDp = new int[colorNum][4];
        // 从左到右 预处理数组
        for (int i = 0; i < colorNum; i++) {
            int currentColor = colors[i];
            for (int j = 1; j <= 3; j++) {
                if (j == currentColor) {
                    leftDp[i][j] = 0;
                } else if (i == 0 || leftDp[i - 1][j] == -1) {
                    leftDp[i][j] = -1;
                } else {
                    leftDp[i][j] = leftDp[i - 1][j] + 1;
                }
            }
        }
        // 从右到左 预处理数组
        for (int i = colorNum - 1; i >= 0; i--) {
            int currentColor = colors[i];
            for (int j = 1; j <= 3; j++) {
                if (j == currentColor) {
                    rightDp[i][j] = 0;
                } else if (i == colorNum - 1 || rightDp[i + 1][j] == -1) {
                    rightDp[i][j] = -1;
                } else {
                    rightDp[i][j] = rightDp[i + 1][j] + 1;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        // 处理queries数组
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int targetColor = queries[i][1];
            int left = leftDp[startIndex][targetColor];
            int right = rightDp[startIndex][targetColor];
            if (left == -1 && right == -1){
                result.add(-1);
            }else if (left == -1){
                result.add(right);
            }else if (right == -1){
                result.add(left);
            }else {
                result.add(Math.min(left,right));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] colors = new int[]{1, 1, 2, 1, 3, 2, 2, 3, 3};
        int[][] queries = new int[][]{{1, 3}, {2, 2}, {6, 1}};
        List<Integer> result = new LeetCode1182与目标颜色间的最短距离().shortestDistanceColor(colors, queries);
        System.out.println(result);
    }
}
