package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/10
 */
public class LeetCode1288删除被覆盖的区间 {

    /**
     * 微软面试模拟
     *
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        }));
        int count = 0;
        int end = 0;
        int prev = 0;
        // left已经是升序排序了 只要按照顺序遍历就一定不会被包含在下一个left中
        // 相同的left下 right按照降序排序 所以当前right有两种可能 1：相同的left 此时right不可能被包含在内 2：不同的left 此时right可能被包含在内
        // 所以只需要考虑2情况 当下一个right大于当前的right时 就出现了包含的情况 需要更新right 并且此时记一次剩余的区间即可
        for (int[] each : intervals) {
            end = each[1];
            if (prev < end) {
                ++count;
                prev = end;
            }
        }
        return count;
    }
}
