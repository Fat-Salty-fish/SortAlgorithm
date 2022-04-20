package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/22
 */
public class LeetCode255验证前序遍历序列二叉搜索树 {

    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }

    /**
     * 根据一个区间来判断
     *
     * @param preorder
     * @param start
     * @param end
     * @return
     */
    public boolean verifyPreorder(int[] preorder, int start, int end) {
        if (end - start < 0) {
            return true;
        }
        int headValue = preorder[start];
        // 找到第一个比head值大的索引
        int rightFirst = start;
        for (; rightFirst <= end; rightFirst++) {
            if (preorder[rightFirst] > headValue) {
                break;
            }
        }
        // rightFirst == headIndex 说明没有比head值大
        // 只要rightFirst 不等于headIndex 那么检查一下rightFirst-end是否有比head值小的节点
        if (rightFirst != end + 1) {
            for (int i = rightFirst; i <= end; i++) {
                if (preorder[i] < headValue) {
                    return false;
                }
            }
        }
        boolean left = verifyPreorder(preorder, start + 1, rightFirst - 1);
        boolean right = verifyPreorder(preorder, rightFirst, end);
        return left && right;
    }

    /**
     * 用单调栈解决
     * 先序遍历BST树时 满足"部分递减，总体递增"的规律 出栈的数总小于要入栈的数
     *
     * @param preorder
     * @return
     */
    public boolean verifyPreorder2(int[] preorder) {
        Deque<Integer> deque = new ArrayDeque<>();
        // max是已经被弹出的元素 没有元素被弹出的时候为Integer.MIN_VALUE
        // 此时位于栈顶的元素是最新的根节点
        int max = Integer.MIN_VALUE;
        for (int j : preorder) {
            if (j < max){
                return false;
            }
            while (!deque.isEmpty() && deque.peek() < j) {
                max = deque.poll();
            }
            deque.push(j);
        }
        return true;
    }
}
