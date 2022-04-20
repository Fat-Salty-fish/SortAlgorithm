package aimToOfferII;

import leetCode.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/4
 */
public class AimToOffer35复杂链表的复制 {

    /**
     * 可以用Map 是否可以不用？
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node result = null;
        Node pre = null;
        Node temp = head;
        while (temp != null) {
            Node current = new Node(temp.val);
            map.put(temp, current);
            if (result == null) {
                result = current;
            }
            if (pre != null) {
                pre.next = current;
            }
            pre = current;
            temp = temp.next;
        }
        temp = head;
        Node resultTemp = result;
        while (temp != null) {
            resultTemp.random = map.get(temp.random);
            temp = temp.next;
            resultTemp = resultTemp.next;
        }
        return result;
    }
}
