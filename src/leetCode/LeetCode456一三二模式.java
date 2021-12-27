package leetCode;

import sun.nio.cs.FastCharsetProvider;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/3 19:26
 */
public class LeetCode456一三二模式 {
    public boolean find132pattern(int[] nums)
    {
        Stack<Integer> temp = new Stack<>();
        if(nums.length < 3){
            return false;
        }
        int length = nums.length;
        int second = Integer.MIN_VALUE;
        //从后往前找 找到比自己大的数字 再找到比自己第二大的数字就可以了
        for(int i = length-1;i >= 0;i--){
            if(nums[i] < second){
                return true;
            }
            while (!temp.isEmpty() && temp.peek() < nums[i]){
                second = Math.max(second,temp.peek());
                temp.pop();
            }
            temp.push(nums[i]);
        }
        return false;
    }
}
