package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author acer
 * @Date 2019/7/10 22:44
 */
public class LeetCode217 {
    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,1]
     * 输出: true
     * 示例 2:
     *
     * 输入: [1,2,3,4]
     * 输出: false
     * 示例 3:
     *
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>(nums.length);
        for(int a:nums){
            if(mySet.contains(a)){
                return true;
            }
            mySet.add(a);
        }
        return false;
    }
}
