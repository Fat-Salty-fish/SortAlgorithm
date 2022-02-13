package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/4
 */
public class LeetCode435无重叠区间 {

    /**
     * 搜索线 训练
     * 如果用动态规划的话感觉有点最长递增子序列的感觉了
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt((o1) -> o1[1]));
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[0] >= right){
                ans++;
                right = currentInterval[1];
            }
        }
        return intervals.length-ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        int result = new LeetCode435无重叠区间().eraseOverlapIntervals(intervals);
    }
}
