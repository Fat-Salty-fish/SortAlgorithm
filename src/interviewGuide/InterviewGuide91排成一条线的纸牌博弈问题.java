package interviewGuide;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/28
 */
public class InterviewGuide91排成一条线的纸牌博弈问题 {

    /**
     * 预测赢家 返回赢家的点数
     *
     * @param array
     * @return
     */
    public int PredictTheWinner(int[] array) {
        int arrayLength = array.length;
        int[][] firstDp = new int[arrayLength][arrayLength];
        int[][] secondDp = new int[arrayLength][arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            firstDp[i][i] = array[i];
        }
        for (int i = arrayLength - 2; i >= 0; i--) {
            for (int j = i + 1; j < arrayLength; j++) {
                firstDp[i][j] = Math.max(array[i] + secondDp[i + 1][j], array[j] + secondDp[i][j - 1]);
                // 此时对于后手来说 已经变成了先手 所以状态转移方程变成了如此 秒啊！
                secondDp[i][j] = Math.min(firstDp[i + 1][j], firstDp[i][j - 1]);
            }
        }
        return Math.max(firstDp[0][arrayLength - 1], secondDp[0][arrayLength - 1]);
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2};
        int result = new InterviewGuide91排成一条线的纸牌博弈问题().PredictTheWinner(array);
        System.out.println(result);
    }
}
