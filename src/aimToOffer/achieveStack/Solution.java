package aimToOffer.achieveStack;

/**
 * @author acer
 * @Date 2019/4/16 20:21
 */

import java.util.Arrays;

/**
 * 实现一个栈 用来显示当前栈内的最小的数 每次的算法复杂度都为O(1) 即常数阶
 * 实现思路 ：使用一个新的数组来保存当前栈内的最小的数即可 每次弹出之后判断弹出的值是否为最小值 如果是则将栈内最小值的数组内的数同时删除即可
 */
public class Solution {


    //用来储存所添加的元素
    private Integer[] elements = new Integer[10];
    //用来储存最小值的元素 从后往前进行删除
    private Integer[] minElements = new Integer[10];
    //用来储存当前元素的个数 不是数组的长度
    private int size = 0;
    //用来储存最小元素的个数 或者说是下标 不是数组的长度
    private int minSize = 0;

    public void push(int node) {
        //首先进行扩容判断
        ensureCapacity(size+1);
        elements[size] = node;
        ++size;
        //如果当前最小元素的个数为0或者新添加的数的大小小于等于当前的栈内的最小值
        if(minSize == 0 || minElements[minSize-1] >= node){
            //先进行扩容判断
            ensureCapacity(minSize+1);
            minElements[minSize] = node;
            ++minSize;
        }
    }

    //判断修改之后的容量 如果当前容量小于修改后的容量则扩容
    private void ensureCapacity(int minCapacity) {
        //如果需要才进行扩容 不需要则不进行扩容
        if(elements.length < minCapacity) {
            int oldCapacity = elements.length;
            //新的容量是原来容量的1.5倍 使用了位运算 速度更快
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    //弹出栈内的最上面的一个数
    public void pop() {
        //只有当元素个数大于0的时候才能够pop
        if(size>0){
            //有两种情况 最小值数组中最后一个数等于栈内的最后一个数
            //或是最小值数组中最后一个数大于栈内最后一个数
            //不可能最小值数组中最后一个数小于栈内最后一个数
            if(elements[size-1] == minElements[minSize-1]){
                minElements[minSize-1] = (Integer)null;
                --minSize;
            }
            elements[size-1] = (Integer)(null);
            size--;
        }
    }

    public int top() {
        //证明数组内元素是存在的
        if(size>0){
            return elements[size-1];
        }else {
            return (Integer)null;
        }
    }

    public int min() {
        if(minSize>0){
            return minElements[minSize-1];
        }else {
            return (Integer)null;
        }
    }

    public static void main(String[] args) {
        Solution mySolution = new Solution();
        mySolution.push(1);
        System.out.println(mySolution.top());
        System.out.println(mySolution.min());
        mySolution.pop();
        System.out.println(mySolution.top());
        System.out.println(mySolution.min());

    }
}
