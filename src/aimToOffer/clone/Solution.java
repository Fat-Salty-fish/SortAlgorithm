package aimToOffer.clone;

import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;
import jdk.internal.org.objectweb.asm.tree.LineNumberNode;

/**
 * @author acer
 * @Date 2019/4/21 17:07
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

// 输入一个复杂链表
// （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        RandomListNode currentNode = pHead;
        //复制每一个节点 并将每一个节点插入当前节点之后
        while(currentNode!=null){
            RandomListNode node = new RandomListNode(currentNode.label);
            node.next = currentNode.next;
            currentNode.next = node;
            currentNode = node.next;
        }
        //设置新创建节点的random节点
        currentNode = pHead;
        while (currentNode!=null){
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next==null?null:currentNode.next.next;
        }
        //将新创建的节点从原链表中剥离出来
        currentNode = pHead;
        RandomListNode headNode = currentNode.next;
        while (currentNode!=null){
            RandomListNode temp = currentNode.next;
            currentNode.next = currentNode.next==null?null:currentNode.next.next;
            temp.next = temp.next==null?null:temp.next.next;
            currentNode = currentNode.next;
        }
        return headNode;
    }

}
