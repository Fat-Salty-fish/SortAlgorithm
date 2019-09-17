package aimToOffer.IsPopOrder;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/4/20 15:00
 */
public class Solution {
    //pushA是压栈顺序 popA是出栈顺序 判断以pushA的顺序能不能有popA的出栈顺序
    //或者popA的顺序是不是可行的出栈顺序
    //如何判断呢
    //在入栈顺序中 在靠后的数字出现之后 靠前的数字一定是理论上的出栈顺序
    //因为在靠后的数字先出栈 那么靠前的数字一定会在栈内 靠前的数字一定不会乱序
    //入栈：12345
    //出栈：43512 是错的
    //出栈：43521 是对的
    //可以采用一种逆序的方法
    //用一个指针指向入栈
    //将出栈循序从后往前遍历 模拟入栈
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        //两个数组的长度一定是相同的 不相同时应该返回否
        if (pushA.length != popA.length) {
            return false;
        }
        //应该如何进行判断呢
        //
        int pushLength = pushA.length;
        int popLength = popA.length;
        Stack<Integer> myStack = new Stack<>();
        int popIndex = 0;
        for(int i =0;i< pushLength;i++){
            //先对数字进行压栈
            myStack.push(pushA[i]);
            //然后进行对比 如果栈顶元素和popA[index]指向的数字相同则出栈
            while ((!myStack.isEmpty())&&myStack.peek() == popA[popIndex]){
                myStack.pop();
                ++popIndex;
            }
        }
        if(myStack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};
        int[] popB = {4, 3, 5, 2, 1};
        System.out.println(new Solution().IsPopOrder(pushA, popA));
    }
}
