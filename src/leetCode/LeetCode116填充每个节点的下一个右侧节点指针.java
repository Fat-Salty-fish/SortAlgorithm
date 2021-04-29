package leetCode;

import java.util.LinkedList;

/**
 * @author acer
 * @Date 2019/7/29 21:46
 */
public class LeetCode116填充每个节点的下一个右侧节点指针 {
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

    /**
     * 二刷116
     *
     * @param root
     * @return
     */
    public Node connect2(Node root){
        if (root == null){
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    /**
     * 连接相邻的节点
     * @param node1
     * @param node2
     * @return
     */
    public void connectTwoNode(Node node1, Node node2) {
        node1.next = node2;
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node1.right, node2.left);
        connectTwoNode(node2.left, node2.right);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1,
                new Node(2,new Node(4,null,null,null),new Node(5,null,null,null),null),
                new Node(3,new Node(6,null,null,null),new Node(7,null,null,null),null),
                null);
        new LeetCode116填充每个节点的下一个右侧节点指针().connect(node1);
    }
}
