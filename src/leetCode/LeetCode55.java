package leetCode;

import com.sun.corba.se.impl.oa.NullServantImpl;
import sun.nio.cs.FastCharsetProvider;

/**
 * @author acer
 * @Date 2019/8/26 18:48
 */
public class LeetCode55 {
    enum index {
        GOOD, BAD, UNKNOWN
    }

    index[] memory;

    public boolean canJump(int[] nums) {
        memory = new index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memory[i] = index.UNKNOWN;
        }
        memory[nums.length - 1] = index.GOOD;
        return caculate(nums, 0);
    }

    public boolean caculate(int[] nums, int position) {
        if (memory[position] != index.UNKNOWN) {
            return memory[position] == index.GOOD ? true : false;
        }
        //可以跳到的最远距离
        int futherJump = Math.min(position + nums[position], nums.length - 1);
        for (int i = position + 1; i <= futherJump; i++) {
            if(caculate(nums,i)){
                memory[position] = index.GOOD;
                return true;
            }
        }
        memory[position] = index.BAD;
        return false;
    }

    public boolean Jump(int[] nums){
        int lastPos = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            if(i+nums[i] >=lastPos){
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
