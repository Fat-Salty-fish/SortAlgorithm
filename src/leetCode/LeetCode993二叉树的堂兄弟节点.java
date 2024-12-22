package leetCode;

import java.util.*;

public class LeetCode993二叉树的堂兄弟节点 {

    /**
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                set.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                if (cur.left != null && cur.right != null){
                    if ((cur.left.val == x && cur.right.val == y) || (cur.left.val == y && cur.right.val == x)){
                        return false;
                    }
                }
            }
            if (set.contains(x) && set.contains(y)){
                return true;
            }
        }
        return false;
    }
}
