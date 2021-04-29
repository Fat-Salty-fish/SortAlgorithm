package leetCode;

import javax.swing.text.MutableAttributeSet;
import java.util.Arrays;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/26 0:30
 */
public class LeetCode559N叉数的最大深度 {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        for(int i = 0 ; i<root.children.size();i++){
            depth = Math.max(depth,maxDepth(root.children.get(i)));
        }
        return depth+1;
    }

    /**
     * 与二叉树类似 遍历list取最大值即可
     * @param root
     * @return
     */
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int childDepth = maxDepth2(root.children.get(i));
            max = Math.max(max, childDepth);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, Arrays.asList(new Node[]{new Node(3, Arrays.asList(new Node[]{new Node(5,null),new Node(6,null)})), new Node(2, null), new Node(4, null)}) );
        System.out.println(new LeetCode559N叉数的最大深度().maxDepth(node1));
    }
}
