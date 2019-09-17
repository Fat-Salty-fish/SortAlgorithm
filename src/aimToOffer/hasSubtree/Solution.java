package aimToOffer.hasSubtree;

/**
 * @author acer
 * @Date 2019/4/14 17:35
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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //运算过程：在root1中先找到与root2根节点相同的值的节点 再判断root2是不是root1的子结构
        //用于返回
        boolean result = false;
        //只有两棵树都不为空的时候才进行运算
        //此时用于寻找两个相同的根节点
        if(root1!=null&&root2!=null){
            if(root1.val == root2.val){
                result = doesTree1HasTree2(root1,root2);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    public static boolean doesTree1HasTree2(TreeNode node1,TreeNode node2){
        //如果tree2遍历完毕并且都能对应的上
        if(node2 == null){
            return true;
        }
        //如果tree1遍历完了结果tree2还没遍历完 肯定2不是1的子结构
        if(node1 == null){
            return false;
        }
        //都未遍历完 则判断当前结点的值是否相同 如果不同则返回否
        if (node1.val != node2.val) {
            return false;
        }

        //此时根节点的值相同 判断子节点的值是否相同
        return doesTree1HasTree2(node1.left,node2.left)&& doesTree1HasTree2(node1.right,node2.right);
    }
}
