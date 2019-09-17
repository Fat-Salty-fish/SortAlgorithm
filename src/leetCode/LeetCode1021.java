package leetCode;

import java.util.Stack;

/**
 * @author acer
 * @Date 2019/5/2 15:51
 */
public class LeetCode1021 {
    public String removeOuterParentheses(String S){
        if(S==null||S.length()>10000||S==""){
            return null;
        }
        //用于返回
        char[] array = S.toCharArray();
        StringBuilder builder = new StringBuilder();
        int num = 0;
        for (int i = 0; i <S.length();i++){
            //如果是左括号 则直接存入栈中
            if (array[i]=='('){
                if(num>0){
                    builder.append(array[i]);
                }
                ++num;
            }
            //如果是右括号 则说明了一次匹配
            //一次匹配时 需要判断此次匹配的是外括号还是内括号 如果是外括号则直接删除
            //如果是内括号则需要添加到builder中
            if(array[i]==')'){
                --num;
                if(num>0){
                    builder.append(array[i]);
                }
            }
        }
        return builder.toString();
    }
}
