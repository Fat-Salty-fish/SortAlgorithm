package aimToOffer.reBuildQueueUsingStack;

import java.util.Stack;

/** 使用两个栈来实现一个队列的pop和push操作
 * @author acer
 * @Date 2019/4/6 16:41
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //当弹出一个节点时 判断2号栈是否为空 如果2号栈不为空则直接将2号栈的栈顶弹出
        //如果2号栈为空 则将1号栈的所有元素都弹出到2号栈 再将2号栈的栈顶元素弹出
        if(!stack2.empty())
            return stack2.pop();
        else {
            if(stack1.empty()){
                return 0;
            }else {
                while (!stack1.empty()){
                    int temp = stack1.pop();
                    stack2.push(temp);
                }
                return stack2.pop();
            }
        }
    }
}
