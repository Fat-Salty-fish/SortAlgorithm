package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/2
 */
public class LeetCode1229安排会议日程 {

    /**
     * 双指针 求交集
     *
     * @param slots1
     * @param slots2
     * @param duration
     * @return
     */
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(slots1, (Comparator.comparingInt(o -> o[0])));
        Arrays.sort(slots2, (Comparator.comparingInt(o -> o[0])));
        int left = 0;
        int right = 0;
        while (left < slots1.length && right < slots2.length) {
            int[] slot1 = slots1[left];
            int[] slot2 = slots2[right];
            // 这里为什么不用判断两个间隔有相交呢
            // 因为如果不相交 end-start就会是负数了
            int start = Math.max(slot1[0], slot2[0]);
            int end = Math.min(slot1[1],slot2[1]);
            if (end - start >= duration){
                result.add(start);
                result.add(start+duration);
                return result;
            }
            if (slot1[1] >= slot2[1]) {
                right++;
            } else {
                left++;
            }
        }
        return result;
    }
}
