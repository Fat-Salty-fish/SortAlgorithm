package aimToOffer.findPath;

import sun.security.tools.PathList;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author acer
 * @Date 2019/4/21 11:52
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution {
    //用来存放路径的数据结构
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    //用来储存一条路径
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return result;
        }
        path.add(root.val);
        //如果节点没有左子节点 没有右子节点 且当前节点的值和所需值相同 则这个路径是符合要求的
        if(root.left==null && root.right == null && target==root.val){
            result.add(new ArrayList<>(path));
        }
        if(root.val<=target&&root.left!=null){
            FindPath(root.left,target-root.val);
        }
        if(root.val<=target&&root.right!=null){
            FindPath(root.right,target-root.val);
        }
        path.remove(path.size()-1);
        return result;
        
    }
}
