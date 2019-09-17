package leetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author acer
 * @Date 2019/8/23 19:55
 */
public class LeetCode268 {
    //缺失的数字
    public int missingNumber(int[] nums) {
        int ans = -1;
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            mySet.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (mySet.contains(nums[i])) {
                mySet.remove(nums[i]);
            }
        }
        Iterator iterator = mySet.iterator();
        if (iterator.hasNext()) {
            ans = (int) iterator.next();
        }
        return ans;
    }

    public int missingNumber2(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i ^ nums[i];
        }
        return ans;
    }
}
