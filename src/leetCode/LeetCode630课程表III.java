package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode630课程表III {


    /**
     * 根据ddl进行排序
     * 用大顶堆维护当前消耗时间最多的课程。逐渐添加课程直到所加的课程无法再添加，把位于顶部的课程去掉即可
     *
     * @param courses
     * @return
     */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (Comparator.comparingInt(o -> o[1])));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int currentSpend = 0;
        int result = 0;
        for (int i = 0; i < courses.length; i++) {
            if (currentSpend + courses[i][0] <= courses[i][1]) {
                pq.add(courses[i]);
                currentSpend += courses[i][0];
                result++;
            } else {
                // 不能直接remove，需要比较一下，如果新添加的消耗的更多，那么没必要
                if (pq.peek() != null && courses[i][0] <= pq.peek()[0]) {
                    int[] removed = pq.poll();
                    pq.add(courses[i]);
                    currentSpend -= removed[0];
                    currentSpend += courses[i][0];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}};
        int result = new LeetCode630课程表III().scheduleCourse(array);
        System.out.println(result);
    }
}
