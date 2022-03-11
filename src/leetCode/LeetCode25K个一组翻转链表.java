package leetCode;

import java.util.*;

public class LeetCode25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        Stack<ListNode> nodeStack = new Stack<>();
        List<ListNode> nodeList = new ArrayList<>();
        int num = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            while (num < k && tempNode != null) {
                nodeStack.push(tempNode);
                num++;
                ListNode curr = tempNode.next;
                tempNode.next = null;
                tempNode = curr;
            }
            if (num == k) {
                while (!nodeStack.isEmpty()) {
                    nodeList.add(nodeStack.pop());
                    num = 0;
                }
            } else {
                while (!nodeStack.isEmpty()) {
                    nodeList.addAll(nodeStack);
                    nodeStack.removeAllElements();
                }
            }
        }
        ListNode dummyNode = new ListNode(-1);
        tempNode = dummyNode;
        for (int i = 0; i < nodeList.size(); i++) {
            tempNode.next = nodeList.get(i);
            tempNode = tempNode.next;
        }
        return dummyNode.next;
    }


    //这个方法是用来反转链表的
    //k表示要反转的链表长度
    public ListNode reverse(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        int n = 0;
        ListNode endNode = null;
        while (head != null && n < k) {
            ListNode temp = dummyNode.next;
            ListNode remember = head.next;
            dummyNode.next = head;
            dummyNode.next.next = temp;
            head = remember;
            n++;
            endNode = remember;
        }
        ListNode node = dummyNode;
        while (node != null && node.next != null) {
            node = node.next;
        }
        node.next = endNode;
        return dummyNode.next;
    }

    /**
     * 前序节点
     */
    ListNode preHead;

    /**
     * 后序节点
     */
    ListNode tailHead;

    /**
     * 本条链条是否需要反转 默认需要 遇到特殊情况下不反转
     */
    Boolean needToReverse = Boolean.TRUE;

    /**
     * 每k个节点反转一次 递归实现
     *
     * @param head 头节点
     * @param k    k个节点
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        // 我们先对k个节点进行反转
        ListNode firstHead = reverseToN(head, k);
        while (tailHead != null && needToReverse) {
            preHead.next = reverseToN(tailHead, k);
        }
        return firstHead;
    }

    /**
     * 从head节点开始 对后面的n个节点进行反转
     * 如果n为1 则表示当前节点为要交换的最后一个节点
     * 因为n为1 所以不需要进行交换 直接返回head
     * 但是需要记录一下当前节点的下一个节点 用来记录转换范围之外的 第一个节点
     * <p>
     * 如果n不为1 则对当前节点与当前节点的下一个节点进行交换
     * nextHead 意为 head.next后的节点已经全部都反转了一次了之后的 头节点
     * 然后进行转换
     * 返回的是当前链表反转k个之后的 头节点！
     *
     * @param head 头节点
     * @param n    n个节点
     * @return 反转之后的头节点
     */
    public ListNode reverseToN(ListNode head, int n) {
        if (head == null) {
            // 如果当前节点为空 说明不需要反转节点 则置为空
            needToReverse = Boolean.FALSE;
            return head;
        }
        if (n == 1) {
            // 头节点实际上来说是当前节点的next 因为再往上一层递归时 当前节点会与当前节点的上一个节点进行反转
            tailHead = head.next;
            return head;
        }
        ListNode nextNode = reverseToN(head.next, n - 1);
        if (needToReverse) {
            preHead = head;
            head.next.next = head;
            head.next = tailHead;
            return nextNode;
        } else {
            return head;
        }
    }


    boolean haveToReverse = Boolean.TRUE;

    /**
     * 前序节点
     */
    ListNode previousNode;

    /**
     * 后序节点
     */
    ListNode nextNode;

    /**
     * 三刷k个一组反转链表
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode finalResult = reverseListWithKNodes(head, k);
        while (nextNode != null && haveToReverse) {
            previousNode.next = reverseListWithKNodes(nextNode, k);
        }
        return finalResult;
    }

    /**
     * 反转接下来的n个节点
     *
     * @param n
     * @return
     */
    public ListNode reverseListWithKNodes(ListNode head, int n) {
        if (head == null) {
            haveToReverse = Boolean.FALSE;
            return null;
        }
        // 此时不用反转
        if (n == 1) {
            nextNode = head.next;
            head.next = null;
            return head;
        }
        ListNode reversedHead = reverseListWithKNodes(head.next, n - 1);
        if (haveToReverse) {
            // 这个节点会作为下一段反转链表的前序节点
            previousNode = head;
            head.next.next = head;
            // 当前节点会作为这段反转链表的最后一个节点 所以必须将下一个节点指向下一段的头节点
            head.next = nextNode;
            return reversedHead;
        } else {
            return head;
        }
    }

    /**
     * 四刷 用栈解决
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup4(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode oriHead = null;
        ListNode lastTail = null;
        ListNode current = head;
        ListNode result = null;
        while (current != null) {
            ListNode tempNext = current.next;
            stack.push(current);
            if (stack.size() == 1) {
                oriHead = current;
            }
            if (stack.size() == k) {
                ListNode next = current.next;
                ListNode reversedListHead = reverseListFromStack(stack);
                if (lastTail == null) {
                    result = reversedListHead;
                } else {
                    lastTail.next = reversedListHead;
                }
                lastTail = oriHead;
                lastTail.next = next;
            }
            current = tempNext;
        }
        return result;
    }

    /**
     * 从栈内反转链表
     *
     * @param stack
     * @return
     */
    public ListNode reverseListFromStack(Deque<ListNode> stack) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return dummyNode.next;
    }

    /**
     * 分组反转链表
     * 每1个、2个、3个、4个反转 如果没有到个数就不反转
     *
     * @param head
     * @return
     */
    public ListNode reverseAsGroupIncreased(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode currentNode = head.next;
        int groupNum = 2;
        ListNode pre = head;
        ListNode next = null;
        while (currentNode != null) {
            stack.push(currentNode);
            next = currentNode.next;
            if (stack.size() == groupNum) {
                while (!stack.isEmpty()) {
                    ListNode temp = stack.pop();
                    pre.next = temp;
                    pre = temp;
                }
                pre.next = next;
                groupNum++;
            }
            currentNode = next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        LeetCode25K个一组翻转链表 leetcode = new LeetCode25K个一组翻转链表();
        ListNode node = leetcode.reverseAsGroupIncreased(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
