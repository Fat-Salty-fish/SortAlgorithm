package competition;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/9
 */
public class LeetCode5979全部开花的最早一天 {


    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] flower = new int[plantTime.length][2];
        for (int i = 0; i < plantTime.length; i++) {
            flower[i] = new int[]{plantTime[i], growTime[i]};
        }
        Arrays.sort(flower, (o1, o2) -> o2[1] - o1[1]);
        int current = 0;
        int result = 0;
        for (int i = 0; i < plantTime.length; i++) {
            current += flower[i][0];
            result = Math.max(result, current + flower[i][1]);
        }
        return result;
    }
}
