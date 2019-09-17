package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author acer
 * @Date 2019/8/7 22:32
 */
public class LeetCode784 {
    public List<String> letterCasePermutation(String S) {
        int letterSize = 0;
        //用来存放S中英文字符的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if ((c >= 'a' && c <= 'z') ||(c>='A' && c<='Z')) {
                letterSize++;
                map.put(letterSize, i);
            }
        }
        List<String> ans = new ArrayList<>();
        if(letterSize == 0){
            ans.add(S);
            return ans;
        }
        for (int i = 0; i < 2 << (letterSize - 1); i++) {
            StringBuilder builder = new StringBuilder(S);
            for (int j = 0; j < letterSize; j++) {
                char current = S.charAt(map.get(letterSize-j));
                if (((i >> j) & 1) == 1) {
                    builder.setCharAt(map.get(letterSize - j), Character.toUpperCase(current));
                }else {
                    builder.setCharAt(map.get(letterSize - j), Character.toLowerCase(current));
                }
            }
            ans.add(builder.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        String S = new String("C");
        List<String> ans = new LeetCode784().letterCasePermutation(S);
        for (String s : ans) {
            System.out.println(s);
        }
    }

}
