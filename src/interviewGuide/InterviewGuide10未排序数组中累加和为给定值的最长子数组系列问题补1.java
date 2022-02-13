package interviewGuide;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/9
 */
public class InterviewGuide10未排序数组中累加和为给定值的最长子数组系列问题补1 {


    /**
     * 将负数都看作为-1
     *
     * @param array
     * @return
     */
    public int maxLength(int[] array) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                sum -= 1;
            } else if (array[i] > 0) {
                sum += 1;
            }
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            }
            map.putIfAbsent(sum, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 1, 1, 1};
        int result = new InterviewGuide10未排序数组中累加和为给定值的最长子数组系列问题补1().maxLength(array);
        System.out.println(result);
    }
}
