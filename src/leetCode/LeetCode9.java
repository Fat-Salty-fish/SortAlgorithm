package leetCode;


/**
 * @author acer
 * @Date 2019/7/2 17:27
 */
public class LeetCode9 {
//    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//    示例 1:
//
//    输入: 121
//    输出: true
//    示例 2:
//
//    输入: -121
//    输出: false
//    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//    示例 3:
//
//    输入: 10
//    输出: false
//    解释: 从右向左读, 为 01 。因此它不是一个回文数。
    //思路：只反转后一半的数字 反转之后与前一半进行比较 如果相同则为回文数
    public boolean isPalindrome(int x) {
        // 如果非0则一定不是回文数
        // 如果最后一位为0 则一定是0才是回文数
        if(x<0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        //用来存放反转后的数字
        int reversedNumber = 0;
        while (x > reversedNumber){
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }
        //当数字为奇数时 可以通过x/10来将最后一位截取掉 中间位置的数字不影响是否回文
        return x == reversedNumber || x == reversedNumber/10;
    }

}
