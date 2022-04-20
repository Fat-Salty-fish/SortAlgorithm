package aimToOfferII;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/4
 */
public class AimToOffer34二叉树中和为某一值的路径 {


    /**
     * 和为某一值的路径
     *
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(), root, target, result);
        return result;
    }


    public void dfs(List<Integer> currentPath, TreeNode root, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (root.val == target && root.left == null && root.right == null) {
            currentPath.add(root.val);
            result.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }
        currentPath.add(root.val);
        dfs(currentPath, root.left, target - root.val, result);
        dfs(currentPath, root.right, target - root.val, result);
        currentPath.remove(currentPath.size() - 1);
    }
}
