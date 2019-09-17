package aimToOffer.reConstructTree;



/** 树的节点类
 * @author acer
 * @Date 2019/4/6 14:44
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void print(){
        System.out.print(val);
        if(left!= null)
            left.print();
        if(right!= null)
            right.print();
    }
}

