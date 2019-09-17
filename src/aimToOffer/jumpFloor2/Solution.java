package aimToOffer.jumpFloor2;


/**
 * @author acer
 * @Date 2019/4/6 21:23
 */
public class Solution {
    public int JumpFloorⅡ(int target) {
        int a = 1;
        return a<<(target-1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloorⅡ(4));
    }
}
