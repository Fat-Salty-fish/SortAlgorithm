package leetCode;

import sun.util.resources.cldr.nd.CurrencyNames_nd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/3 9:00
 */
public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
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

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        new LeetCode103().zigzagLevelOrder(head);
    }
}
