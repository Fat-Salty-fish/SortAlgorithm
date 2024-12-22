package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/29 21:46
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public List<Node> neighbors = new ArrayList<>();
    public Node parent;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
