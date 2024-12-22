package leetCode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author acer
 * @Date 2019/9/3 9:00
 */
public class LeetCode103二叉树的锯齿层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int condition = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            LinkedList<TreeNode> temp = new LinkedList<>();
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pollFirst();
                current.add(curr.val);
                if (condition == 1) {
                    //condition不同时 先添加左右节点的顺序不同
                    if (curr.right != null) {
                        temp.addFirst(curr.right);
                    }
                    if (curr.left != null) {
                        temp.addFirst(curr.left);
                    }
                } else if (condition == 0) {
                    if (curr.left != null) {
                        temp.addFirst(curr.left);
                    }
                    if (curr.right != null) {
                        temp.addFirst(curr.right);
                    }
                }
            }
            //将正行的遍历结果添加到最终结果中
            ans.add(current);
            //将下一行添加到栈中
            stack.addAll(temp);
            ///转换condition的状态
            condition = condition == 0 ? 1 : 0;
        }
        return ans;
    }

    /**
     * 层序遍历
     * 用一个标记位标记是否反转即可
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right!= null){
                    queue.offer(node.right);
                }
                current.add(node.val);
            }
            if (leftToRight) {
                current = current.reversed();
            }
            leftToRight = !leftToRight;
            result.add(current);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        new LeetCode103二叉树的锯齿层序遍历().zigzagLevelOrder(head);
    }
}
