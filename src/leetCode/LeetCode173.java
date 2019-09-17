package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/3 2:20
 */
public class LeetCode173 {
    class BSTIterator {
        List<Integer> vals = new ArrayList<>();
        int curr = 0;
        int size = 0;

        public BSTIterator(TreeNode root) {
            TreeNode pointer = root;
            Stack<TreeNode> stack = new Stack<>();
            while (pointer != null || !stack.isEmpty()) {
                while (pointer != null) {
                    stack.push(pointer);
                    pointer = pointer.left;
                }
                pointer = stack.pop();
                vals.add(pointer.val);
                pointer = pointer.right;

            }
            this.size = vals.size();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            int ans = vals.get(curr);
            curr++;
            return ans;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return curr < size;
        }
    }
}
