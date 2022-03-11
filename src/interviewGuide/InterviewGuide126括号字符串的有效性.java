package interviewGuide;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/5
 */
public class InterviewGuide126括号字符串的有效性 {


    /**
     * 检查括号是否有效 字符串内只有'(' 和 ')'
     * @param str
     * @return
     */
    public boolean check(String str){
        if (str == null || str.length() == 0){
            return true;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char temp:str.toCharArray()){
            if (temp != '(' && temp != ')'){
                return false;
            }
            if (temp == '('){
                deque.push('(');
            }else {
                if (deque.isEmpty()){
                    return false;
                }
                deque.pop();
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean result = new InterviewGuide126括号字符串的有效性().check(str);
        if (result){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
