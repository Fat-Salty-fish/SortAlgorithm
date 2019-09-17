package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/26 21:21
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backTrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backTrack(ans, cur + "(", open + 1, close, max);

        //close < open 必须有左括号的情况下才添加右括号 防止右括号多余左括号的现象
        if (close < open)
            backTrack(ans, cur + ")", open, close + 1, max);

    }
}
