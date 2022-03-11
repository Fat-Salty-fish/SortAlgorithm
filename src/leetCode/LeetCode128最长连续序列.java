package leetCode;

import interviewGuide.InterviewGuide92跳跃游戏;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/27
 */
public class LeetCode128最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestIncreaseTime = 0;
        for (int num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            int thisLongestNum = 1;
            while (numSet.contains(++num)) {
                thisLongestNum++;
            }
            longestIncreaseTime = Math.max(longestIncreaseTime, thisLongestNum);
        }
        return longestIncreaseTime;
    }

    /**
     * 最长连续序列 2刷
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int temp : nums) {
            set.add(temp);
        }
        int length = 0;
        for (int temp : set) {
            if (set.contains(temp - 1)) {
                continue;
            }
            int tempLength = 1;
            while (set.contains(temp + 1)) {
                tempLength++;
                temp += 1;
            }
            length = Math.max(length, tempLength);
        }
        return length;
    }
}
