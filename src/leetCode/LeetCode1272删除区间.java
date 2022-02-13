package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/4
 */
public class LeetCode1272删除区间 {

    /**
     * 区间三兄弟
     *
     * @param intervals
     * @param toBeRemoved
     * @return
     */
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        if (intervals == null || intervals.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        if (toBeRemoved == null || toBeRemoved.length == 0) {
            for (int i = 0; i < intervals.length; i++) {
                result.add(Arrays.stream(intervals[i]).boxed().collect(Collectors.toList()));
            }
            return result;
        }
        int index = 0;
        while (index < intervals.length) {
            int[] currentArray = intervals[index];
            if (currentArray[1] <= toBeRemoved[0] || currentArray[0] > toBeRemoved[1]) {
                result.add(Arrays.stream(currentArray).boxed().collect(Collectors.toList()));
                index++;
            } else {
                // 需要分成两段
                if (currentArray[0] < toBeRemoved[0]) {
                    result.add(Arrays.asList(currentArray[0], toBeRemoved[0]));
                    if (currentArray[1] > toBeRemoved[1]) {
                        result.add(Arrays.asList(toBeRemoved[1], currentArray[1]));
                    }
                } else if (currentArray[0] == toBeRemoved[0]) {
                    if (currentArray[1] > toBeRemoved[1]) {
                        result.add(Arrays.asList(toBeRemoved[1], currentArray[1]));
                    }
                } else {
                    if (currentArray[1] > toBeRemoved[1]) {
                        result.add(Arrays.asList(toBeRemoved[1], currentArray[1]));
                    }
                }
                index++;
            }
        }
        return result;
    }
}
