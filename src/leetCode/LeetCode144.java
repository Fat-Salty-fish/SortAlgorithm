package leetCode;

import org.jsoup.select.Evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/1 1:53
 */
public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        //后序遍历 就是将前序遍历反转过来 所以可以将前序遍历反转过来就是后续遍历了？
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        //迭代法遍历二叉树
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            temp = stack.pop();
            ans.add(temp.val);
            //先添加右节点再添加左节点
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
        return ans ;
    }
}
