package leetCode;

import com.sun.webkit.ContextMenuItem;
import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author acer
 * @Date 2019/9/2 19:00
 */
public class LeetCode316 {
    public String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            //获得当前的字符
            Character character = s.charAt(i);
            //如果栈中已经存在这个字符 则直接跳过
            if (stack.contains(character)){
                continue;
            }
            while (!stack.isEmpty() && stack.peekFirst() > character && s.lastIndexOf(stack.peek()) > i){
                stack.pop();
            }
            stack.push(character);
        }
        StringBuilder builder = new StringBuilder("");
        while (!stack.isEmpty()){
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode316().removeDuplicateLetters("bcabc"));
    }
}
