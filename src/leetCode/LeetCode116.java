package leetCode;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TooManyListenersException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author acer
 * @Date 2019/7/29 21:46
 */
public class LeetCode116 {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            LinkedList<Node> temp = new LinkedList<>(queue);
            queue.clear();
            Node last = null;
            Node now = null;
            while (!temp.isEmpty()){
                //逐个弹出
                now = temp.pop();
                if (last != null) {
                    last.next = now;
                }
                last = now;
                if (now.left != null)
                    queue.add(now.left);
                if (now.right != null)
                    queue.add(now.right);
            }
            now.next = null;
        }
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1,
                new Node(2,new Node(4,null,null,null),new Node(5,null,null,null),null),
                new Node(3,new Node(6,null,null,null),new Node(7,null,null,null),null),
                null);
        new LeetCode116().connect(node1);
    }
}
