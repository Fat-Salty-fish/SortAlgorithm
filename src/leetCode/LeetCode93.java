package leetCode;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/8/29 18:28
 */
public class LeetCode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        int length = s.length();
        if (length < 4 || length > 12) {
            return ans;
        }
        //调用函数 dfs
        solution(s, ans, new ArrayList<>(), 0, length);
        return ans;
    }

    public void solution(String s, List<String> ans, List<String> path, int current, int length) {
        //将结果添加到ans中
        if (current == length && path.size() == 4) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                builder.append(path.get(i));
                builder.append('.');
            }
            builder.delete(builder.length() - 1, builder.length());
            ans.add(builder.toString());
            return;
        }
        if (current == length) {
            return;
        }
        if (path.size() >= 4) {
            return;
        }
        //分别获取接下来的三个字符
        Character first = s.charAt(current);
        Character second = null;
        Character third = null;
        if (current < length - 1) {
            second = s.charAt(current + 1);
        }
        if (current < length - 2) {
            third = s.charAt(current + 2);
        }

        //三位都有效
        //则可以分为三个
        if (second != null && third != null) {
            if (first != '0' && (first - '0') * 100 + (second - '0') * 10 + (third - '0') <= 255 && (first - '0') * 100 + (second - '0') * 10 + (third - '0') >= 0) {
                path.add(s.substring(current, current + 3));
                solution(s, ans, path, current + 3, length);
                path.remove(path.size() - 1);
            }
            //两位有效 最多分2个
        }
        if (second != null) {
            if (first != '0' && (first - '0') * 10 + (second - '0') >= 0 && (first - '0') * 10 + (second - '0') <= 255) {
                path.add(s.substring(current, current + 2));
                solution(s, ans, path, current + 2, length);
                path.remove(path.size() - 1);
            }
        }
        //只能分成1个了
        if (first - '0' >= 0) {
            path.add(s.substring(current, current + 1));
            solution(s, ans, path, current + 1, length);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> ans = new LeetCode93().restoreIpAddresses("010010");
        for (String a : ans) {
            System.out.println(a);
        }
    }
}
