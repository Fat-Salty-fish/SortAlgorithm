package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/17 19:08
 */
public class LeetCode230二叉搜索树中第K小的元素 {
    //采用dfs 对二叉树进行中序遍历
    int ans = -1;
    int current = 0;

    public int kthSmallest(TreeNode root, int k) {
        mid(root, k);
        return ans;
    }

    public void mid(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        mid(node.left, k);
        if (current == k) {
            return;
        }
        current += 1;
        if (current == k) {
            ans = node.val;
            return;
        }
        mid(node.right, k);
    }

    /**
     * 二刷
     * 最简单思路：用二叉搜索树构造出一个数组出来
     * 最后遍历数组
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> resultArray = new ArrayList<>();
        buildArray(root, resultArray);
        return resultArray.get(k - 1);
    }

    public void buildArray(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        buildArray(node.left, result);
        result.add(node.val);
        buildArray(node.right, result);
    }

    public int currentRank = 0;

    public int result = 0;

    /**
     * 三刷
     * 优化二刷：不使用数组维护 维护排序
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest3(TreeNode root, int k) {
        buildResult(root, k);
        return result;
    }

    /**
     * 中序遍历二叉树
     * 并更新数字
     *
     * @param root
     * @param k
     */
    public void buildResult(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        buildResult(root.left, k);
        currentRank++;
        if (currentRank == k) {
            result = root.val;
        }
        buildResult(root.right, k);
    }

    /**
     * 节点个数
     */
    public int nodeNum = 0;

    /**
     * 结果值
     */
    public int answer = -1;

    public int targetK = 0;

    //四刷
    public int kthSmallest4(TreeNode head, int k) {
        targetK = k;
        search(head);
        return answer;
    }

    public void search(TreeNode node) {
        if (node == null) {
            return;
        }
        search(node.left);
        nodeNum++;
        if (nodeNum == targetK) {
            answer = node.val;
            return;
        }
        search(node.right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(4);
        head.left.right = new TreeNode(2);
        System.out.println(new LeetCode230二叉搜索树中第K小的元素().kthSmallest2(head, 1));
    }
}
