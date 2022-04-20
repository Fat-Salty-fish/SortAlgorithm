package aimToOfferII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/6
 */
public class AimToOffer51数组中的逆序对 {

    /**
     * 逆序对
     * 看起来就是单调栈
     * 单调栈解决不了...得归并排序 不做了
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int result = 0;
        for (int temp : nums) {
            if (deque.isEmpty()) {
                deque.push(temp);
            } else {
                while (!deque.isEmpty() && deque.peek() <= temp) {
                    deque.pop();
                }
                result += deque.size();
                deque.push(temp);
            }
        }
        return result;
    }
}
