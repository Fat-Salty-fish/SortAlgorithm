package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/14
 */
public class LeetCode1666改变二叉树的根节点 {

    /**
     * 根据题意进行实现即可
     *
     * @param root
     * @param leaf
     * @return
     */
    public Node flipBinaryTree(Node root, Node leaf) {
        Node result = leaf;
        Node parent = leaf.parent;
        Node current = leaf;
        Node last = null;
        while (current != root) {
            if (current.left != null) {
                current.right = current.left;
                current.left = null;
            }
            parent = current.parent;
            current.left = current.parent;
            current.parent = last;
            if (parent.left == current) {
                parent.left = null;
            }
            if (parent.right == current) {
                parent.right = null;
            }
            last = current;
            current = parent;
        }
        root.parent = last;
        return result;
    }

    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node6 = new Node(6);
        Node node2 = new Node(2);
        Node node0 = new Node(0);
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node4 = new Node(4);
        node3.left = node5;
        node3.right = node1;
        node5.parent = node3;
        node1.parent = node3;
        node5.left = node6;
        node5.right = node2;
        node6.parent = node5;
        node2.parent = node5;
        node2.left = node7;
        node2.right = node4;
        node7.parent = node2;
        node4.parent = node2;
        node1.left = node0;
        node1.right = node8;
        node0.parent = node1;
        node8.parent = node1;
        Node result = new LeetCode1666改变二叉树的根节点().flipBinaryTree(node3, node7);
        System.out.println(result.val);
    }
}
