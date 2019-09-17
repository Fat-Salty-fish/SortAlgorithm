package leetCode;

/**
 * @author acer
 * @Date 2019/8/18 0:56
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] start = new int[nums.length];
        int[] end = new int[nums.length];
        int[] ans = new int[nums.length];
        //第一个数组 每一个空格存放num[0]*num[2]...*num[n]
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            temp *= nums[i];
            start[i] = temp;
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp *= nums[i];
            end[i] = temp;
        }
        temp = 1;
        for(int i = 0;i<ans.length;i++){
            if(i == 0){
                ans[i] = end[i+1];
            }else if(i == ans.length-1){
                ans[i] = start[i-1];
            }else {
                ans[i] = end[i+1]*start[i-1];
            }
        }
        return ans;
    }
}
