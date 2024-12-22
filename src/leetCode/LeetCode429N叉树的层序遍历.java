package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode429N叉树的层序遍历 {

    /**
     * 几乎无差别
     * 二叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return  new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node n: node.children) {
                    queue.add(n);
                }
            }
            result.add(list);
        }
        return result;
    }
}
