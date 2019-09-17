package aimToOffer.fibonacciNumber;


/** 输入一个n 求第n位的斐波那契数是多少 假设输入0为0 1为1 2为1
 * @author acer
 * @Date 2019/4/6 20:42
 */
public class Solution {
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1|| n == 2){
            return 1;
        }else{
            return Fibonacci(n,1,1,3);
        }
    }

    private int Fibonacci(int n,int n1, int n2,int time){
        if(time<n){
            return Fibonacci(n,n2,n1+n2,++time);
        }else {
            return n1+n2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Fibonacci(6));
    }
}
