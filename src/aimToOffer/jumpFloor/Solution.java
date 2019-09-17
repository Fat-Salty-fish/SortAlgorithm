package aimToOffer.jumpFloor;

/**
 * 青蛙跳问题 如果一只青蛙每次只会跳一个或者两个台阶 那么它跳n个台阶有多少种方法？
 * 这个问题类似于斐波那契数列的解法
 *
 * @author acer
 * @Date 2019/4/6 20:58
 */
public class Solution {
    public int JumpFloor(int target) {
        if (target <= 0)
            return 0;
        else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        else {
            return JumpFloor(target,1,2,3);
        }
    }

    //要计算n个台阶的跳跃方法 只要知道n-1个台阶的跳跃方法和n-2个台阶的跳跃方法即可
    //因为n个台阶的跳跃方法等于n-1个台阶的跳跃方法+n-2个台阶的跳跃方法+1+2即可
    private int JumpFloor(int target,int n1,int n2,int time){
        if(time <target){
            return JumpFloor(target,n2,n1+n2,++time);
        }else {
            return n1+n2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloor(3));
    }
}
