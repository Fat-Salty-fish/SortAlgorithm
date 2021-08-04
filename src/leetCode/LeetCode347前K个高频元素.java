package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lizhongjie
 * @Date 2021/8/3
 * @Desc
 **/
public class LeetCode347前K个高频元素 {

    /**
     * 返回nums数组中出现频率前k个高的数字
     * 用Map?
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int a : nums) {
            if (numMap.containsKey(a)){
                numMap.put(a,numMap.get(a)+1);
            }else {
                numMap.put(a,1);
            }
        }
        Map<Integer,Integer> reverse = new HashMap<>();
        for (Map.Entry<Integer,Integer> entry:numMap.entrySet()){
            reverse.put(entry.getValue(),entry.getKey());
        }
        return
    }
}
