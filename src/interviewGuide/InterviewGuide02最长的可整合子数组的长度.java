package interviewGuide;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/12
 */
public class InterviewGuide02最长的可整合子数组的长度 {

    /**
     * 用动态规划感觉可以 啊！不行
     * 需要知道每个位置的最大值和最小值
     *
     * @param array
     * @return
     */
    public int getLength(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            Set<Integer> existed = new HashSet<>();
            for (int j = i; j < array.length; j++) {
                if (existed.contains(array[j])) {
                    break;
                }
                existed.add(array[j]);
                max = Math.max(max, array[j]);
                min = Math.min(min, array[j]);
                if (max - min + 1 == j - i + 1) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {5, 5, 3, 2, 6, 4, 3};
        int result = new InterviewGuide02最长的可整合子数组的长度().getLength(array);
        System.out.println(result);
    }
}
