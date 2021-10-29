package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/10/23
 */
public class LeetCode1301最大得分的路径数 {

    /**
     * 正方形边长
     */
    public int boardLength;

    /**
     * 对此数取余数
     */
    public int mod = 1000000007;

    /**
     * 最大得分的路径数
     * 先从dfs开始考虑吧
     * 自顶向下
     *
     * @param board
     * @return
     */
    public int[] pathsWithMaxScore(List<String> board) {
        boardLength = board.size();
        ScoreAndPlanNum[][] dp = new ScoreAndPlanNum[boardLength][boardLength];
        ScoreAndPlanNum lastOne = new ScoreAndPlanNum();
        lastOne.setScore(0);
        lastOne.setPlanNum(1);
        dp[boardLength - 1][boardLength - 1] = lastOne;
        for (int i = boardLength - 1; i >= 0; i--) {
            for (int j = boardLength - 1; j >= 0; j--) {
                ScoreAndPlanNum current = new ScoreAndPlanNum();
                current.setScore(0);
                current.setPlanNum(0);
                // 处于右下角
                if (i == boardLength - 1 && j == boardLength - 1) {
                    current.setPlanNum(1);
                    continue;
                }
                // 此路不通 此时score应该等于多少？
                if (board.get(i).charAt(j) == 'X') {
                    current.setScore(-1);
                    dp[i][j] = current;
                    continue;
                }
                ScoreAndPlanNum down = ScoreAndPlanNum.getX();
                if (i + 1 <= boardLength - 1) {
                    down = dp[i + 1][j];
                }
                ScoreAndPlanNum right = ScoreAndPlanNum.getX();
                if (j + 1 <= boardLength - 1) {
                    right = dp[i][j + 1];
                }
                ScoreAndPlanNum rightDown = ScoreAndPlanNum.getX();
                if (i + 1 <= boardLength - 1 && j + 1 <= boardLength - 1) {
                    rightDown = dp[i + 1][j + 1];
                }
                // 三路不通 此路就不通
                if (down.getScore() == -1 && right.getScore() == -1 && rightDown.getScore() == -1){
                    current.setScore(-1);
                    dp[i][j] = current;
                    continue;
                }
                ScoreAndPlanNum maxScore = getMaxScoreOfThree(down, right, rightDown);
                maxScore.setPlanNum(0);
                if (down != null && maxScore.getScore() == down.getScore()) {
                    maxScore.setPlanNum((maxScore.getPlanNum() + down.getPlanNum()) % mod);
                }
                if (right != null && maxScore.getScore() == right.getScore()) {
                    maxScore.setPlanNum((maxScore.getPlanNum() + right.getPlanNum()) % mod);
                }
                if (rightDown != null && maxScore.getScore() == rightDown.getScore()) {
                    maxScore.setPlanNum((maxScore.getPlanNum() + rightDown.getPlanNum() % mod));
                }
                if (i != 0 || j != 0) {
                    maxScore.setScore(maxScore.getScore() + (board.get(i).charAt(j) - '0'));
                }
                current.setScore(maxScore.score % mod);
                current.setPlanNum(maxScore.planNum);
                dp[i][j] = current;
            }
        }
        if (dp[0][0].getScore() == -1){
            return new int[]{0,0};
        }
        return new int[]{dp[0][0].getScore(), dp[0][0].getPlanNum()};
    }

    /**
     * 用于保存得分以及方案数
     */
    static class ScoreAndPlanNum {
        /**
         * 得分数
         */
        public int score;

        /**
         * 当前得分下的方案数
         */
        public int planNum;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getPlanNum() {
            return planNum;
        }

        public void setPlanNum(int planNum) {
            this.planNum = planNum;
        }

        public static ScoreAndPlanNum getNormal() {
            ScoreAndPlanNum normal = new ScoreAndPlanNum();
            normal.setScore(0);
            normal.setPlanNum(1);
            return normal;
        }

        /**
         * 此处无法通行
         * @return
         */
        public static ScoreAndPlanNum getX(){
            ScoreAndPlanNum x = new ScoreAndPlanNum();
            x.setScore(-1);
            x.setPlanNum(0);
            return x;
        }

        public ScoreAndPlanNum() {
        }

        public ScoreAndPlanNum(ScoreAndPlanNum copy) {
            this.score = copy.getScore();
            this.planNum = copy.getPlanNum();
        }


    }

    public ScoreAndPlanNum getMaxScoreOfThree(ScoreAndPlanNum first, ScoreAndPlanNum second, ScoreAndPlanNum third) {
        if (first == null && second == null && third == null) {
            return ScoreAndPlanNum.getNormal();
        }
        if (first == null) {
            return getMaxScoreOfTwo(second, third);
        }
        if (second == null) {
            return getMaxScoreOfTwo(first, third);
        }
        if (third == null) {
            return getMaxScoreOfTwo(first, second);
        }
        ScoreAndPlanNum firstBig = first.getScore() > second.getScore() ? first : second;
        return new ScoreAndPlanNum(firstBig.getScore() > third.getScore() ? firstBig : third);
    }

    public ScoreAndPlanNum getMaxScoreOfTwo(ScoreAndPlanNum first, ScoreAndPlanNum second) {
        if (first == null && second == null) {
            return ScoreAndPlanNum.getNormal();
        }
        if (first == null) {
            return new ScoreAndPlanNum(second);
        }
        if (second == null) {
            return new ScoreAndPlanNum(first);
        }
        return new ScoreAndPlanNum(first.getScore() > second.getScore() ? first : second);
    }

    public static void main(String[] args) {
        String a = "E23";
        String b = "2X2";
        String c = "12S";
        List<String> stringList = new ArrayList<>();
        stringList.add(a);
        stringList.add(b);
        stringList.add(c);
        int[] result = new LeetCode1301最大得分的路径数().pathsWithMaxScore(stringList);
    }
}
