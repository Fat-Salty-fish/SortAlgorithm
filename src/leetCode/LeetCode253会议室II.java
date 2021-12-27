package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/24
 */
public class LeetCode253会议室II {

    /**
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }
        Arrays.sort(intervals, Comparator.comparingInt((o1) -> o1[0]));
        // 小顶堆 用来排序结束时间 将结束时间完成最早的抛出来
        PriorityQueue<Integer> stack = new PriorityQueue<>();
        stack.offer(intervals[0][1]);
        for (int i = 1;i<intervals.length;i++){
            int[] currentMeeting = intervals[i];
            if (currentMeeting[0] < stack.peek()){
                stack.offer(currentMeeting[1]);
            }else {
                stack.poll();
                stack.offer(currentMeeting[1]);
            }
        }
        return stack.size();
    }
}
