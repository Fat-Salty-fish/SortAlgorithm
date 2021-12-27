package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/3
 */
public class LeetCode174地下城游戏 {

    /**
     * 感觉是动态规划即可解决
     * 需要从右下角开始往左和上进行遍历
     * dp[i][j] 表示从(i,j)开始 走到右下角时需要的初始命数
     * 所以遍历dp时从右下角开始 向左上角遍历 只能向左和向上进行遍历
     * Math.min(right,down)决定了下一步往哪里走 -dungeon[i][j]来计算从当前位置出发是否还需要消耗点数 并且和1做比较 如果大于1则需要更多的点数 如果小于1说明只要当前有1点生命值即可
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int rowNum = dungeon.length;
        int colNum = dungeon[0].length;
        int[][] dp = new int[rowNum][colNum];
        dp[rowNum - 1][colNum - 1] = dungeon[rowNum - 1][colNum - 1] < 0 ? -dungeon[rowNum - 1][colNum - 1] + 1 : 1;
        for (int i = rowNum - 1; i >= 0; i--) {
            for (int j = colNum - 1; j >= 0; j--) {
                // 最后一格直接跳过
                if (i + 1 >= rowNum && j + 1 >= colNum) {
                    continue;
                }
                int down = i + 1 < rowNum ? dp[i + 1][j] : Integer.MAX_VALUE;
                int right = j + 1 < colNum ? dp[i][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = Math.max(Math.min(down, right) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] array = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int result = new LeetCode174地下城游戏().calculateMinimumHP(array);
        System.out.println("结果为:" + result);
    }
}
