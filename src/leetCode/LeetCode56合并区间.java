package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/24
 */
public class LeetCode56合并区间 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        List<int[]> arrayList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o1 -> o1[0]));
        int left = 0;
        int right = 1;
        while (right < intervals.length) {
            int[] currentFirstArray = intervals[left];
            int[] currentSecondArray = intervals[right];
            if (currentFirstArray[1] < currentSecondArray[0]) {
                arrayList.add(currentFirstArray);
                left = right;
                right = left + 1;
            } else {
                // 说明有交集 合并
                currentFirstArray[1] = Math.max(currentFirstArray[1], currentSecondArray[1]);
                right = right + 1;
            }
        }
        if (left < intervals.length) {
            arrayList.add(intervals[left]);
        }
        return arrayList.toArray(new int[arrayList.size()][]);
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = new LeetCode56合并区间().merge(array);
        System.out.println(result[0][1]);
    }
}
