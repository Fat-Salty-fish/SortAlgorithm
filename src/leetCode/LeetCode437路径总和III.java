package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/12/11
 */
public class LeetCode437路径总和III {
    /**
     * 路径总和
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        result += checkPath(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }


    public int checkPath(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val == targetSum) {
            result++;
        }
        if (root.left != null) {
            result += checkPath(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            result += checkPath(root.right, targetSum - root.val);
        }
        return result;
    }

    /**
     * 前缀和解决
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum2(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        return prefix(root, targetSum, prefixMap, 0);
    }

    /**
     * 用前缀和解决
     *
     * @param root
     * @param targetSum
     * @param prefixMap
     * @param currentSum
     * @return
     */
    public int prefix(TreeNode root, int targetSum, Map<Integer, Integer> prefixMap, int currentSum) {
        if (root == null) {
            return 0;
        }
        int tempCurrent = currentSum + root.val;
        int result = 0;
        if (prefixMap.containsKey(tempCurrent - targetSum)) {
            result += prefixMap.get(tempCurrent - targetSum);
        }
        prefixMap.put(tempCurrent, prefixMap.getOrDefault(tempCurrent, 0) + 1);
        result += prefix(root.left, targetSum, prefixMap, tempCurrent);
        result += prefix(root.right, targetSum, prefixMap, tempCurrent);
        if (prefixMap.get(tempCurrent) == 1) {
            prefixMap.remove(tempCurrent);
        } else {
            prefixMap.put(tempCurrent, prefixMap.get(tempCurrent) - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node4.right = node5;
        node3.right = node4;
        node2.right = node3;
        node1.right = node2;

        System.out.println(new LeetCode437路径总和III().pathSum(node1, 3));
    }
}
