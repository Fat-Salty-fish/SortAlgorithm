package leetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/28 23:39
 */
public class LeetCode872叶子相似的树 {
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

    /**
     * 二刷872题
     * 尝试降低空间复杂度
     * 除了迭代器没什么好的办法
     * 还是先不实现迭代器了
     * @param root1 第一棵树
     * @param root2 第二棵树
     * @return
     */
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        List<Integer> arrayList1 = findLeaf(root1);
        List<Integer> arrayList2 = findLeaf(root2);
        if (arrayList1.size() != arrayList2.size()) {
            return false;
        }
        for (int i = 0; i < arrayList1.size(); i++) {
            if (!(arrayList1.get(i).equals(arrayList2.get(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 迭代中序遍历二叉树 并构造叶子结点数组
     *
     * @param root
     * @return
     */
    public List<Integer> findLeaf(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> leafArray = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode head = root;
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            // 说明是叶子节点
            if (head.left == null && head.right == null) {
                leafArray.add(head.val);
            }
            head = head.right;
        }
        return leafArray;
    }

}
