package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/31
 */
public class LeetCode1688比赛中的配对次数 {


    public int numberOfMatches(int n) {
        int result = 0;
        int leftTeams = n;
        while (leftTeams > 1) {
            int half = leftTeams / 2;
            result += half;
            leftTeams -= half;
        }
        return result;
    }
}
