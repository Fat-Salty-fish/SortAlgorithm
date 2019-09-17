package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/1 2:02
 */
public class LeetCode94二叉树中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()){
            //这里会不断添加非叶子节点
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}
