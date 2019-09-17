package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/1 2:13
 */
public class LeetCode145 {
    //迭代解决二叉树后序遍历
    public List<Integer> postorderTraversal(TreeNode root){
        //使用了一个LinkedList 采用了逆序的方法添加数字
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = null;
        while (!stack.isEmpty()){
            curr = stack.pop();
            //注意 这里使用的addFirst方法
            //而且和前序遍历不同的是 前序遍历先添加右节点再添加左节点
            //而后续遍历是先添加左节点再添加右节点
            ans.addFirst(curr.val);
            if(curr.left!=null){
                stack.add(curr.left);
            }
            if(curr.right!=null){
                stack.add(curr.right);
            }
        }
        return ans;
    }
}
