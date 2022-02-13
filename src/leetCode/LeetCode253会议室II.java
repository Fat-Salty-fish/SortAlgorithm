package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/24
 */
public class LeetCode253会议室II {

    /**
     * 将所有的会议时间的结束时间放到一个小顶堆中
     * 遍历每个会议 如果这个会议的开始时间比小顶堆的结束时间大 说明已经空出来一个会议室了 可以使用空的会议室
     *
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
        for (int i = 1; i < intervals.length; i++) {
            int[] currentMeeting = intervals[i];
            if (currentMeeting[0] < stack.peek()) {
                stack.offer(currentMeeting[1]);
            } else {
                stack.poll();
                stack.offer(currentMeeting[1]);
            }
        }
        return stack.size();
    }

    /**
     * 二刷
     * 扫描线
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms2(int[][] intervals) {
        List<int[]> search = new ArrayList<>();
        // 表示一个会议的开始和结束 如果一个会议开始了 则加一 如果一个会议结束了 则减1
        for (int i = 0; i < intervals.length; i++) {
            int[] meeting = intervals[i];
            search.add(new int[]{meeting[0], 1});
            search.add(new int[]{meeting[1], -1});
        }
        Collections.sort(search, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        int currentMeeting = 0;
        int result = 0;
        for (int[] array : search) {
            currentMeeting += array[1];
            result = Math.max(result, currentMeeting);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int result = new LeetCode253会议室II().minMeetingRooms2(array);
        System.out.println(result);
    }
}
