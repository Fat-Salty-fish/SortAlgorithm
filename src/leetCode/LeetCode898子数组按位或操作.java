package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/14
 */
public class LeetCode898子数组按位或操作 {


    /**
     * 先尝试暴力解法 会导致超时
     * 然后优化：每一个以j结尾的前缀或操作后 最多只会有32个1变得不同 所以用Set来去重前一个前缀或的结果
     * @param arr
     * @return
     */
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            Set<Integer> current = new HashSet<>();
            for (Integer tested:set){
                current.add(now | tested);
            }
            current.add(now);
            set = current;
            result.addAll(current);
        }
        return result.size();
    }
}
