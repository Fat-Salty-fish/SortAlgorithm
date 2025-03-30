package leetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode202快乐数 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)){
            int next = sumOfSquaresOfDigits(n);
            if (next == 1) {
                return true;
            }
            set.add(n);
            n = next;
        }
        return false;
    }

    public int sumOfSquaresOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean result = new LeetCode202快乐数().isHappy(19);
        System.out.println(result);
    }
}
