package leetCode;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/30 21:47
 */
public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return findPath(root,0);
    }

    public int findPath(TreeNode node,int sum){
        if(node ==null){
            return 0;
        }
        sum = 10*sum+node.val;
        if(node.left == null && node.right ==null){
            return sum;
        }
        return findPath(node.left,sum)+findPath(node.right,sum);
    }
//
//    public int sumNumbers(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        List<Integer> ans = new LinkedList<>();
//        List<Integer> current = new LinkedList<>();
//        findPath(ans,current,root);
//        return ans.stream().reduce(Math::addExact).get();
//    }
//
//    public void findPath(List<Integer> ans ,List<Integer> current,TreeNode node){
//        LinkedList<Integer> list = null;
//        if(node!=null){
//            current.add(node.val);
//            list = new LinkedList<>(current);
//            if(node.left!=null){
//                findPath(ans,current,node.left);
//            }
//            if (node.right != null) {
//                findPath(ans,current,node.right);
//            }
//            if(node.left == null && node.left ==null){
//                StringBuilder builder = new StringBuilder();
//                for(Integer i:current){
//                    builder.append(i);
//                }
//                ans.add(Integer.valueOf(builder.toString()));
//            }
//            current.remove(current.size()-1);
//        }
//    }

}
