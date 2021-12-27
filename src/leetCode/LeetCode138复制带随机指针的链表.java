package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/24
 */
public class LeetCode138复制带随机指针的链表 {

    /**
     * 用来保存对应节点
     */
    public Map<Node,Node> nodeMapForRandom = new HashMap<>();


    public Node copyRandomList(Node head) {
        if (head == null ){
            return null;
        }
        // 复制原链表是容易的 问题在于如何复制原链表内的随机指针节点
        // 用一个Map看起来是个不错的方法
        Node newNode = new Node(head.val);
        nodeMapForRandom.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        if (head.random == null){
            newNode.random = null;
        }else if (head.random == head){
            newNode.random = newNode;
        }else {
            newNode.random = nodeMapForRandom.get(head.random);
        }
        return newNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        Node result = new LeetCode138复制带随机指针的链表().copyRandomList(node1);
        System.out.println(result.val);
    }
}
