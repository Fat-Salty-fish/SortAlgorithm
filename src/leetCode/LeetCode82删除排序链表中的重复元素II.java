package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/11/26
 */
public class LeetCode82删除排序链表中的重复元素II {

    /**
     * 用来记录上一个同时出现的数字 用来判断这个数字是否要添加到最后的结果节点中
     */
    public Integer lastNumOfShowTwice = null;

    private int numOfCurrentNumberShowsUp = 1;

    /**
     * 删除排序链表里的重复元素 留下只出现一次的节点
     * 用三个指针 第一个指针为结果指针 dummyNode
     * 第二个指针和第三个指针用来形成组合？
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode result = dummyNode;

        ListNode firstNode = head;
        ListNode secondNode = head;
        while (firstNode != null) {
            // second找到下一个数 并标记当前的数出现了几次
            while (secondNode != null && secondNode.val == firstNode.val) {
                if (secondNode != firstNode) {
                    numOfCurrentNumberShowsUp++;
                }
                secondNode = secondNode.next;
            }
            // 如果当前数出现没超过1次 则可以加到最后的链表内
            if (numOfCurrentNumberShowsUp == 1) {
                dummyNode.next = firstNode;
                dummyNode = dummyNode.next;
            }
            // 将firstNode指向secondNode
            firstNode = secondNode;
            numOfCurrentNumberShowsUp = 1;
        }
        dummyNode.next = null;
        return result.next;
    }

    /**
     * 微软模拟面试
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        ListNode result = dummyNode;
        ListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.next == null || (currentNode.val != currentNode.next.val)) {
                dummyNode.next = currentNode;
                dummyNode = dummyNode.next;
                currentNode = currentNode.next;
            } else {
                int val = currentNode.val;
                while (currentNode != null && currentNode.val == val) {
                    currentNode = currentNode.next;
                }
                if (currentNode == null) {
                    break;
                }
            }
        }
        dummyNode.next = null;
        return result.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 5};
        ListNode node = new ListNode(-1);
        ListNode result = node;
        for (int a : nums) {
            ListNode currentNode = new ListNode(a);
            node.next = currentNode;
            node = node.next;
        }
        ListNode myResult = new LeetCode82删除排序链表中的重复元素II().deleteDuplicates2(result.next);
        while (myResult != null) {
            System.out.println(myResult.val);
            myResult = myResult.next;
        }
    }
}
