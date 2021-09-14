package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/16
 */
public class LeetCode539最小时间差 {

    /**
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.isEmpty()) {
            return 0;
        }
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] nums = time.split(":");
            int hour = Integer.parseInt(nums[0]);
            int minute = Integer.parseInt(nums[1]);
            int thisMinute = hour * 60 + minute;
            minutes.add(thisMinute);
            minutes.add(thisMinute + 24 * 60);
        }
        minutes = minutes.stream().sorted().collect(Collectors.toList());
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.size() - 1; i++) {
            int a = minutes.get(i);
            int b = minutes.get(i + 1);
            result = Math.min(b - a, result);
        }
        return result;
    }
}
