package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/24
 */
public class LeetCode366寻找二叉树的叶子节点 {

    /**
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while (!removeFromTree(root, result)) {
        }
        return result;
    }


    /**
     * 用于检查是否已经执行完毕了
     *
     * @param root
     * @param result
     * @return
     */
    public boolean removeFromTree(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return true;
        }
        if (checkIfChild(root)) {
            List<Integer> removeHead = new ArrayList<>();
            removeHead.add(root.val);
            result.add(removeHead);
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> removed = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    if (checkIfChild(temp.left)) {
                        removed.add(temp.left.val);
                        temp.left = null;
                    } else {
                        queue.offer(temp.left);
                    }
                }
                if (temp.right != null) {
                    if (checkIfChild(temp.right)) {
                        removed.add(temp.right.val);
                        temp.right = null;
                    } else {
                        queue.offer(temp.right);
                    }
                }
            }
        }
        result.add(removed);
        return false;
    }

    /**
     * 检查某个节点是否为叶子节点
     *
     * @param root
     * @return
     */
    public boolean checkIfChild(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }

    int max = Integer.MIN_VALUE;

    int min = Integer.MAX_VALUE;


    public List<List<Integer>> findLeaves2(TreeNode root) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();
        // 自底向上 求深度
        dfs(root, result);
        for (int i = min;i<=max;i++){
            if (result.containsKey(i)){
                resultList.add(result.get(i));
            }
        }
        return resultList;
    }

    public int dfs(TreeNode root, Map<Integer, List<Integer>> resultMap) {
        if (root == null) {
            return -1;
        }
        int left = dfs(root.left, resultMap);
        int right = dfs(root.right, resultMap);
        int currentDepth = Math.max(left, right) + 1;
        max = Math.max(max,currentDepth);
        min = Math.min(min,currentDepth);
        List<Integer> list = resultMap.getOrDefault(currentDepth, new ArrayList<>());
        list.add(root.val);
        resultMap.put(currentDepth, list);
        return currentDepth;
    }


}
