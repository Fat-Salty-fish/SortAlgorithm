package interviewGuide;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/13
 */
public class InterviewGuide168二叉树的按层打印与ZigZag打印 {

    public List<Integer> printTreeByZigZag(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        boolean rightToLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (rightToLeft) {
                    TreeNode temp = queue.pollLast();
                    result.add(temp.val);
                    if (temp.right != null) {
                        queue.addFirst(temp.right);
                    }
                    if (temp.left != null) {
                        queue.addFirst(temp.left);
                    }
                } else {
                    TreeNode temp = queue.pollFirst();
                    result.add(temp.val);
                    if (temp.left != null) {
                        queue.addLast(temp.left);
                    }
                    if (temp.right != null) {
                        queue.addLast(temp.right);
                    }
                }
            }
            rightToLeft = !rightToLeft;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        TreeNode head2 = new TreeNode(2);
        TreeNode head3 = new TreeNode(3);
        TreeNode head4 = new TreeNode(4);
        TreeNode head5 = new TreeNode(5);
        TreeNode head6 = new TreeNode(6);
        TreeNode head7 = new TreeNode(7);
        head1.left = head2;
        head1.right = head3;
        head2.left = head4;
        head2.right = head5;
        head3.left = head6;
        head3.right = head7;
        List<Integer> result = new InterviewGuide168二叉树的按层打印与ZigZag打印().printTreeByZigZag(head1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
