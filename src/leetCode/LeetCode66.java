package leetCode;

/**
 * @author acer
 * @Date 2019/8/22 22:59
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            //这里判断一下是否有进位
            digits[i] = digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
            return digits;
        }
    }
