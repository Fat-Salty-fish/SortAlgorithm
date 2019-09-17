package aimToOffer.power;

import static java.lang.Math.abs;

/** 给定一个底数base与一个项数exponent 求base的exponent的次方
 * @author acer
 * @Date 2019/4/7 14:27
 */

public class Solution {
    //base为底数 exponent为指数
    public double Power(double base, int exponent) {
        //res用于展示结果 curr用于获取基数
        double res = 1,curr = base;
        //n用于计算项数
        int n ;
        //判断项数
        if(exponent>0){
            n = exponent;
            //指数小于0时 结果为幂的分数
        }else if(exponent<0) {
            if(base == 0){
                throw new RuntimeException("分母不能为0");
            }else {
                n = -exponent;
            }
        }else {
            return 1;   //0的0次方为1 任何数的0次方也都为1
        }
        //进行幂的计算
        while (n != 0){
            //获取项数的二进制位数
            //比如exponent为11 则二进制为1011
            //则先获取最小位进行计算
            //这里使用了快速幂方法
            if((n&1)==1){
                res = res * curr;
            }
            curr*=curr;
            n>>=1;   //右移一位
        }
        //判断指数是否为负数 如果为负数则要返回幂的倒数
        return exponent>=0?res:(1/res);
    }
}
