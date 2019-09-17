package leetCode;

/**
 * @author acer
 * @Date 2019/7/25 15:33
 */
public class LeetCode70 {
    //    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//注意：给定 n 是一个正整数。
//
//示例 1：
//
//输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//示例 2：
//
//输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int i = 3;
            int[] array = new int[n+1];
//            array[1]=1;
            int temp1 = 1;
            int temp2 = 2 ;
//            array[2]=2;
            int ans = 0;
            while (i <= n) {
//                array[i] = array[i-1]+array[i-2];
//                i++;
                ans = temp1 + temp2;
                temp1 = temp2;
                temp2 = ans;
                i++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode70().climbStairs2(5  ));
    }
}
