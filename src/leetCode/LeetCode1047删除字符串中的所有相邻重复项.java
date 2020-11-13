package leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2020/9/14
 */
public class LeetCode1047删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String S) {
        if (null == S || S.length() <= 1) {
            return S;
        }
        LinkedList<Character> characterList = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            Character currentChar = S.charAt(i);
            characterList.push(currentChar);
            if (characterList.size() >= 2) {
                Character firstChar = characterList.get(0);
                Character secondChar = characterList.get(1);
                if (firstChar.equals(secondChar)) {
                    characterList.pop();
                    characterList.pop();
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = characterList.size() - 1; i >= 0; i--) {
            builder.append(characterList.get(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String S = "abbaca";
        String test = new LeetCode1047删除字符串中的所有相邻重复项().removeDuplicates(S);
        System.out.println("结果:" + test);
    }
}
