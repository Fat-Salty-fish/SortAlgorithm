package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/28 23:48
 */
public class LeetCode897 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        mid(root,ans);
        TreeNode myRoot = new TreeNode(-1);
        TreeNode now = myRoot;
        for(int i = 0;i<ans.size();i++){
            TreeNode temp = new TreeNode(ans.get(i));
            now.right = temp;
            now = now.right;
        }
        return myRoot.right;
    }

    public void mid(TreeNode node, List<Integer> list){
        if(node!=null){
            mid(node.left,list);
            list.add(node.val);
            mid(node.right,list);
        }
    }
}
