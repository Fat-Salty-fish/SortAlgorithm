package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode1822数组元素积的符号 {

    public int arraySign(int[] nums) {
        int negativeNum = 0;
        boolean haveZero = false;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] < 0){
                negativeNum++;
            }else if (nums[i] == 0){
                haveZero = true;
            }
        }
        if (haveZero){
            return 0;
        }
        if (negativeNum % 2 == 0){
            return 1;
        }
        return -1;
    }

}
