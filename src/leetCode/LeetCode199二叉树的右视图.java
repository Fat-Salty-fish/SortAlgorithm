package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/4/11
 */
public class LeetCode199二叉树的右视图 {

    /**
     * 左/右视图的二叉树
     * 本质上就是层序遍历二叉树
     * 使用两个队列来实现
     * 保证每次只有一个队列中有值即可
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        // 结果list
        List<Integer> result = new ArrayList<>();
        // 使用两个queue来实现 每一次只遍历其中一个queue
        Queue<TreeNode> firstQueue = new LinkedList<>();
        Queue<TreeNode> secondQueue = new LinkedList<>();
        firstQueue.offer(root);
        Integer addNum = null;
        // 只要一个queue不为空 即进行遍历
        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()){
            TreeNode currentNode;
            if (!firstQueue.isEmpty()) {
                while (!firstQueue.isEmpty()){
                    currentNode = firstQueue.poll();
                    addNum = currentNode.val;
                    if (currentNode.left!=null){
                        secondQueue.offer(currentNode.left);
                    }
                    if (currentNode.right!=null){
                        secondQueue.offer(currentNode.right);
                    }
                }
            } else {
                while (!secondQueue.isEmpty()){
                    currentNode = secondQueue.poll();
                    addNum = currentNode.val;
                    if (currentNode.left!=null){
                        firstQueue.offer(currentNode.left);
                    }
                    if (currentNode.right!=null){
                        firstQueue.offer(currentNode.right);
                    }
                }
            }
            result.add(addNum);
        }
        return result;
    }
}
