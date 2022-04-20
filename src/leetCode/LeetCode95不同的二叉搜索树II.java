package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/22
 */
public class LeetCode95不同的二叉搜索树II {

    /**
     * 不同的二叉搜索树
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return build(1,n);
    }

    /**
     * 对于start-end的区间进行构建二叉搜索树
     * 这个区间可以组成多个结果
     *
     * @param start
     * @param end
     * @return
     */
    public List<TreeNode> build(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = new ArrayList<>();
            if (i - 1 >= start) {
                leftList = build(start, i - 1);
            }
            List<TreeNode> rightList = new ArrayList<>();
            if (i + 1 <= end) {
                rightList = build(i + 1, end);
            }
            if (leftList.isEmpty() && rightList.isEmpty()) {
                result.add(new TreeNode(i));
            } else if (leftList.isEmpty()) {
                for (TreeNode right : rightList) {
                    TreeNode temp = new TreeNode(i);
                    temp.right = right;
                    result.add(temp);
                }
            } else if (rightList.isEmpty()) {
                for (TreeNode left : leftList) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = left;
                    result.add(temp);
                }
            }else {
                for (TreeNode left:leftList){
                    for (TreeNode right:rightList){
                        TreeNode temp = new TreeNode(i);
                        temp.left = left;
                        temp.right = right;
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }
}
