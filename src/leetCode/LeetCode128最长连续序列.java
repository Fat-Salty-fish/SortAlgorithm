package leetCode;

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
        for (int num:numSet){
            if (numSet.contains(num-1)){
                continue;
            }
            int thisLongestNum = 1;
            while (numSet.contains(++num)){
                thisLongestNum++;
            }
            longestIncreaseTime = Math.max(longestIncreaseTime,thisLongestNum);
        }
        return longestIncreaseTime;
    }
}
