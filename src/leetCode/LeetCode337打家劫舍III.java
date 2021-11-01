package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/14
 */
public class LeetCode337打家劫舍III {

    public Map<TreeNode, Integer> dpMap = new HashMap<>();

    /**
     * 打家劫舍III 看起来不用动态规划？
     * 无法用遍历构造出数组来进行动态规划 因为关系不相同
     * 加个备忘录
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dpMap.containsKey(root)) {
            return dpMap.get(root);
        }
        int choose = root.val + (root.left == null ? 0 : (rob(root.left.left) + rob(root.left.right))) + (root.right == null ? 0 : (rob(root.right.left) + rob(root.right.right)));
        int notChoose = rob(root.left) + rob(root.right);
        Integer max = Math.max(choose, notChoose);
        dpMap.put(root, max);
        return max;
    }
}
