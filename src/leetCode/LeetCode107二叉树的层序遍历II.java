package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/3
 */
public class LeetCode107二叉树的层序遍历II {

    /**
     * bfs之后再逆序一遍？
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 如何层序遍历？
        LinkedList<TreeNode> firstQueue = new LinkedList<>();
        LinkedList<TreeNode> secondQueue = new LinkedList<>();
        firstQueue.push(root);
        boolean addToFirst = false;
        List<List<Integer>> order = new ArrayList<>();
        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            // 如果要向第一个队列里添加节点 则说明第二个队列里是满的 否则说明第一个队列是满的
            if (addToFirst) {
                while (!secondQueue.isEmpty()) {
                    TreeNode currentNode = secondQueue.pollLast();
                    if (currentNode.left != null) {
                        firstQueue.push(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        firstQueue.push(currentNode.right);
                    }
                    currentLevel.add(currentNode.val);
                }
                addToFirst = false;
            } else {
                while (!firstQueue.isEmpty()) {
                    TreeNode currentNode = firstQueue.pollLast();
                    if (currentNode.left != null) {
                        secondQueue.push(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        secondQueue.push(currentNode.right);
                    }
                    currentLevel.add(currentNode.val);
                }
                addToFirst = true;
            }
            order.add(0, currentLevel);
        }
        return order;
    }

    /**
     * 层序遍历后反转数组即可
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode temp = queue.poll();
                currentLevel.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(currentLevel);
        }
        result = result.reversed();
        return result;
    }
}
