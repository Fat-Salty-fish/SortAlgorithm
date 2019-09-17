package aimToOffer.rectangle;


/** 使用2*1的砖块来铺满2*n的格子 可以有多少种方法？
 * @author acer
 * @Date 2019/4/7 10:15
 */
public class Solution {
    public int RectCover(int target) {
        //递归解决 也可以类似动态规划 从下往上进行计算
        //如果宽为小于等于1 则只有一种方法
        //如果宽为2 则有两种方法
        //如果第一次是 横着摆放两个砖块 即宽度减少了1
        //如果第一次是 竖着摆放了砖块  即宽度减少了2
        //宽度减少1和2之后的摆放方法加起来即为当前砖块的摆放方法
        if(target <= 0){
            return 0;
        }else if(target == 1){
            return 1;
        }else if(target == 2 ){
            return 2 ;
        }else {
            return RectCover(target,1,2,3);
        }
    }

    private int RectCover(int target,int n1,int n2,int time){
        if(time<target){
            return RectCover(target,n2,n1+n2,++time);
        }else {
            return n1+n2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().RectCover(3));
    }
}
