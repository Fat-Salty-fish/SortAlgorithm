package leetCode;

/**
 * @author acer
 * @Date 2019/5/4 11:28
 */
public class LeetCode292 {
    //Nim游戏 每次轮流拿掉1-3块石头 拿掉最后一块石头的人就是获胜者 你作为先手
    //判断是否能够赢得胜利
    public boolean canWinNim(int n) {
        if(n%4==0)
            return false;
        else
            return true;
    }

}
