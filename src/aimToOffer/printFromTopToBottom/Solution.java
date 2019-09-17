package aimToOffer.printFromTopToBottom;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author acer
 * @Date 2019/4/20 16:58
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    //从上往下打印一棵树 同层之间从左往右打印
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while (!nodeList.isEmpty()){
            TreeNode node = nodeList.poll();
            result.add(node.val);
            if(node.left!=null){
                nodeList.offer(node.left);
            }
            if(node.right!=null){
                nodeList.offer(node.right);
            }
        }
        return result;
    }
}
