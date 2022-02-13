package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/4
 */
public class LeetCode57插入区间 {

    /**
     * 搜索线训练
     * 题目已经确定intervals是有序的了
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> intervalList = new ArrayList<>();
        int index = 0;
        boolean used = false;
        while (index < intervals.length) {
            // 判断newInterval在当前区间的左边还是右边 如果在左边 则立即插入
            // 如果在右边 则不插入
            // 如果重叠 则合并后插入
            int[] currentInterval = intervals[index];
            if (used){
                intervalList.add(currentInterval);
                index++;
                used = true;
                continue;
            }
            if (newInterval[1] < currentInterval[0]) {
                intervalList.add(newInterval);
                intervalList.add(currentInterval);
                index++;
            } else if (newInterval[0] > currentInterval[1]) {
                intervalList.add(currentInterval);
                index++;
            } else {
                // 需要合并
                int[] result = mergeTwoIntervals(newInterval, intervals[index]);
                used = true;
                index++;
                while (index < intervals.length && result[1] >= intervals[index][0]) {
                    result = mergeTwoIntervals(result, intervals[index]);
                    index++;
                }
                intervalList.add(result);
            }
        }
        if (!used) {
            intervalList.add(newInterval);
        }
        return intervalList.toArray(new int[intervalList.size()][]);
    }

    /**
     * 合并两个区间
     *
     * @param first
     * @param second
     * @return
     */
    public int[] mergeTwoIntervals(int[] first, int[] second) {
        return new int[]{Math.min(first[0], second[0]), Math.max(first[1], second[1])};
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] array = {4, 8};
        int[][] result = new LeetCode57插入区间().insert(intervals, array);
        System.out.println(result);
    }
}
