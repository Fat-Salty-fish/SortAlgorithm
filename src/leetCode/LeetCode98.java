package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/29 9:37
 */
public class LeetCode98 {
//    public boolean isValidBST(TreeNode root) {
//        if (root != null) {
//            if(root.left == null && root.right == null){
//                return true;
//            }else if(root.left == null){
//                return root.val < root.right.val && isValidBST(root.right);
//            }else if(root.right == null){
//                return root.val > root.left.val && isValidBST(root.left);
//            }else {
//                return root.val < root.right.val && root.val > root.left.val && isValidBST(root.left) && isValidBST(root.right);
//            }
//        } else {
//            return true;
//        }
//    }

    public boolean isValidBST(TreeNode root){
        List<Integer> list = new ArrayList<>();
        fillInList(root,list);
        return isIncrement(list);
    }

    public void fillInList(TreeNode node, List<Integer> list ){
        if(node!=null){
            fillInList(node.left,list);
            list.add(node.val);
            fillInList(node.right,list);
        }
    }

    public boolean isIncrement(List<Integer> list){
        for (int i = 0; i<list.size();i++){
            if(i+1 < list.size() && list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
