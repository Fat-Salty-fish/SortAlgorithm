package interviewGuide;

import leetCode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/9
 */
public class InterviewGuide165在二叉树中找到累加和为指定值的最长路径长度 {


    public Map<Integer, Integer> map;

    public int maxLength(TreeNode head, int k) {
        map = new HashMap<>();
        map.put(0, 0);
        return maxLengthWithTreeNode(head, k, 0, 1);
    }

    public int maxLengthWithTreeNode(TreeNode head, int targetK, int sum, int currentLevel) {
        if (head == null) {
            return 0;
        }
        sum += head.val;
        int result = 0;
        if (map.containsKey(sum - targetK) && currentLevel > map.get(sum - targetK)) {
            result = Math.max(result, currentLevel - map.get(sum - targetK));
        }
        map.putIfAbsent(sum, currentLevel);
        result = Math.max(result, maxLengthWithTreeNode(head.left, targetK, sum, currentLevel + 1));
        result = Math.max(result, maxLengthWithTreeNode(head.right, targetK, sum, currentLevel + 1));
        // 这里需要删除 因为一棵树从上到下 如果不删除 会导致右边的节点拿到不属于这个路径的节点值
        if (map.get(sum) == currentLevel) {
            map.remove(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-3);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(-9);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        int result = new InterviewGuide165在二叉树中找到累加和为指定值的最长路径长度().maxLength(node1, -9);
        System.out.println(result);
    }
}
