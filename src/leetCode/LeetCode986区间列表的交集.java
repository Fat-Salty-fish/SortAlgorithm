package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/4
 */
public class LeetCode986区间列表的交集 {

    /**
     * 扫描线特训
     *
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][];
        }
        List<int[]> arrayList = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < firstList.length && secondIndex < secondList.length) {
            int[] firstInterval = firstList[firstIndex];
            int[] secondInterval = secondList[secondIndex];
            int start = Math.max(firstInterval[0], secondInterval[0]);
            int end = Math.min(firstInterval[1], secondInterval[1]);
            if (end >= start) {
                arrayList.add(new int[]{start, end});
            }
            if (firstInterval[1] > secondInterval[1]) {
                secondIndex++;
            } else {
                firstIndex++;
            }
        }
        return arrayList.toArray(new int[arrayList.size()][]);
    }
}
