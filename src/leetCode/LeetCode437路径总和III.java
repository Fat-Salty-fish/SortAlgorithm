package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/12/11
 */
public class LeetCode437路径总和III {
    /**
     * 用于表示结果
     */
    int result = 0;

    int finalTarget = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        finalTarget = sum;
        findPath(root, sum);
        return result;
    }

    List<List<Integer>> resultList = new ArrayList<>();

    /**
     * 寻找路径
     * 对于每个节点 需要寻找两次
     * @param root
     * @param target
     */
    public void findPath(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        int temp = target - root.val;
//        currentList.add(root.val);
        if (temp == 0) {
            result += 1;
//            resultList.add(new ArrayList<>(currentList));
        }
        findPath(root.left, temp);
        findPath(root.right, temp);
        List<Integer> thisList = new ArrayList<>();
        thisList.add(root.val);
        // 这么写会导致节点值与目标值相同的情况可能会被多次执行 结果比预期结果更大
        findPath(root.left, finalTarget);
        findPath(root.right, finalTarget);
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

        System.out.println(new LeetCode437路径总和III().pathSum(node1,3));
    }
}
