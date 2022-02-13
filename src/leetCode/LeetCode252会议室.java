package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/4
 */
public class LeetCode252会议室 {

    /**
     * 扫描线算法
     * 但其实这里就是一个排序即可
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((o1) -> o1[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
