package interviewGuide;

import java.util.Scanner;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/12
 */
public class InterviewGuide8未排序正数数组中累加和为给定值的最长子数组的长度 {

    /**
     * 双指针
     *
     * @param array
     * @return
     */
    public int maxLength(int[] array, int target) {
        int left = 0;
        int right = 0;
        int sum = array[0];
        int result = 0;
        while (right < array.length) {
            if (sum == target) {
                result = Math.max(result, right - left + 1);
                right++;
                if (right == array.length) {
                    break;
                }
                sum += array[right];
            } else if (sum > target) {
                sum -= array[left++];
            } else {
                right++;
                if (right == array.length){
                    break;
                }
                sum += array[right];
            }
        }
        return result;
    }

}
