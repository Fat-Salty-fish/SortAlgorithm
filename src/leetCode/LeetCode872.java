package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/28 23:39
 */
public class LeetCode872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaf = new ArrayList<>();
        List<Integer> root2Leaf = new ArrayList<>();
        findLeaf(root1,root1Leaf);
        findLeaf(root2,root2Leaf);
        return root1Leaf.equals(root2Leaf);
    }

    public void findLeaf(TreeNode node,List<Integer> list){
        if(node!= null){
            if(node.left == null && node.right == null){
                list.add(node.val);
            }else {
                findLeaf(node.left,list);
                findLeaf(node.right,list);
            }
        }
    }

}
