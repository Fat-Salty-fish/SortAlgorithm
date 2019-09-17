package leetCode;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author acer
 * @Date 2019/7/26 0:30
 */
public class LeetCode559 {
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
        if(root == null) return 0;
        int depth = 0;
        for(int i = 0 ; i<root.children.size();i++){
            depth = Math.max(depth,maxDepth(root.children.get(i)));
        }
        return depth+1;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, Arrays.asList(new Node[]{new Node(3, Arrays.asList(new Node[]{new Node(5,null),new Node(6,null)})), new Node(2, null), new Node(4, null)}) );
        System.out.println(new LeetCode559().maxDepth(node1));
    }
}
