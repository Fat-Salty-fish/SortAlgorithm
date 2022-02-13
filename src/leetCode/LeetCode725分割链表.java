package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode725分割链表 {


    /**
     * 保存链表长度
     */
    int listSize = 0;

    /**
     * 微软模拟面试第二道
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        getListSize(head);
        if (listSize <= k) {
            ListNode[] resultArray = new ListNode[k];
            int index = 0;
            while (head != null) {
                ListNode nextHead = head.next;
                head.next = null;
                resultArray[index++] = head;
                head = nextHead;
            }
            return resultArray;
        }

        ListNode[] resultArray = new ListNode[k];
        int eachSize = listSize / k;
        int overFlow = listSize - (eachSize * k);
        int[][] resultGroup = new int[k][2];
        int left = 0;
        for (int i = 0; i < k; i++) {
            int[] temp = new int[2];
            if (overFlow == 0) {
                temp[0] = left;
                temp[1] = left + eachSize - 1;
                resultGroup[i] = temp;
                left = left + eachSize;
            } else {
                temp[0] = left;
                temp[1] = left + eachSize;
                resultGroup[i] = temp;
                left = left + eachSize + 1;
                overFlow--;
            }
        }
        int currentIndex = 0;
        int currentNode = 0;
        ListNode tempHead = null;
        while (head != null) {
            ListNode nextHead = head.next;
            if (currentNode == resultGroup[currentIndex][0]) {
                tempHead = head;
            }
            if (currentNode == resultGroup[currentIndex][1]) {
                resultArray[currentIndex] = tempHead;
                head.next = null;
                currentIndex++;
            }
            currentNode++;
            head = nextHead;
        }
        return resultArray;
    }

    /**
     * 统计列表长度
     *
     * @param head
     */
    public void getListSize(ListNode head) {
        if (head == null) {
            return;
        }
        listSize++;
        getListSize(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 3; i++) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = temp.next;
        }
        ListNode[] result = new LeetCode725分割链表().splitListToParts(head,2);
    }
}
