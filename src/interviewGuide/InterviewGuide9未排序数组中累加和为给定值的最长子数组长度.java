package interviewGuide;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/9
 */
public class InterviewGuide9未排序数组中累加和为给定值的最长子数组长度 {

    /**
     * 求给定的数组中 和为目标值n的子数组中的最大长度
     *
     * @param array
     * @param n
     * @return
     */
    public int maxLength(int[] array, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (map.containsKey(sum - n)) {
                result = Math.max(result, i - map.get(sum - n));
            }
            map.putIfAbsent(sum, i);
        }
        return result;
    }

}
