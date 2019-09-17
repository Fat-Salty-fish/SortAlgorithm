package leetCode;

/**
 * @author acer
 * @Date 2019/8/29 19:30
 */


import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        //跳台阶问题
        Scanner in = new Scanner(System.in);
        //n为输入的总台阶数
        int n = in.nextInt();
        if(n == 0){
            System.out.println(0);
        }else if(n == 1){
            System.out.println(1);
        }else if (n == 2){
            System.out.println(2);
        }else {
            System.out.println(solution(1,2,3,n));
        }
    }

    public static int solution(int n1,int n2,int current,int target){
        if(current == target){
            return n1+n2;
        }else {
            return solution(n2,n1+n2,current+1,target);
        }
    }
}
