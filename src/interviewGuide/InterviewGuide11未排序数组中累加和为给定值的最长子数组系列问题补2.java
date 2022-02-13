package interviewGuide;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/9
 */
public class InterviewGuide11未排序数组中累加和为给定值的最长子数组系列问题补2 {

    /**
     * 现在成了0和1了
     * 把1当作1 把0当作-1
     *
     * @param array
     * @return
     */
    public int maxLength(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                sum += 1;
            } else {
                sum -= 1;
            }
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            }
            map.putIfAbsent(sum, i);
        }
        return result;
    }
}
