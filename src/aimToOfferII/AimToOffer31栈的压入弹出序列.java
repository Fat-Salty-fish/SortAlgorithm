package aimToOfferII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/31
 */
public class AimToOffer31栈的压入弹出序列 {

    /**
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        if (pushed.length == 0 || popped.length == 0) {
            return false;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex != popped.length) {
            while (stack.isEmpty() || stack.peek() != popped[popIndex]) {
                if (pushIndex < pushed.length) {
                    stack.push(pushed[pushIndex++]);
                } else {
                    break;
                }
            }
            if (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};

        boolean result = new AimToOffer31栈的压入弹出序列().validateStackSequences(pushed, popped);
    }
}
