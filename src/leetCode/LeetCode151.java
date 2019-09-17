package leetCode;

import javax.sound.midi.MidiSystem;
import java.lang.reflect.AnnotatedArrayType;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/8/29 20:59
 */
public class LeetCode151 {
    //使用了库函数
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }
        s = s.trim();
        s = s.replaceAll(" {2,}", " ");
        String[] array = s.split(" ");
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            String temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        StringBuilder builder = new StringBuilder();
        for (String a : array) {
            builder.append(a);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    //使用栈
    public String reverseWords2(String s) {
        if (s == null) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            //left指针下不为空格
            int left = i;
            //right找到下一个空格的前一个
            int right = i;
            while (right < s.length() && s.charAt(right) != ' ') {
                right++;
            }
            String temp = s.substring(left,right);
            stack.add(temp);
            //设置i的位置
            i = right;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.append(stack.pop());
            builder.append(" ");
        }
        if(builder.length()!=0){
            builder.deleteCharAt(builder.length()-1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode151().reverseWords2("a good   example"));
    }
}
