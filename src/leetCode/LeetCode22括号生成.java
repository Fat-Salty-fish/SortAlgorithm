package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author acer
 * @Date 2019/8/26 21:21
 */
public class LeetCode22括号生成 {
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

    /**
     * 二刷
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, result, 0, 0, "");
        return result;
    }

    public void dfs(int target, List<String> paths, int left, int right, String temp) {
        if (left + right == target * 2) {
            paths.add(temp);
            return;
        }
        if (left < target) {
            dfs(target, paths, left + 1, right, temp + "(");
        }
        if (right < left) {
            dfs(target, paths, left, right + 1, temp + ")");
        }
    }

    /**
     * BFS 三刷
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis3(int n) {
        Queue<Temp> queue = new LinkedList<>();
        queue.offer(new Temp("", n, n));
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            Temp temp = queue.poll();
            if (temp.left == temp.right && temp.left == 0) {
                ans.add(temp.str);
            }
            if (temp.left > 0) {
                queue.offer(new Temp(temp.str + "(", temp.left - 1, temp.right));
            }
            if (temp.right > temp.left && temp.right > 0) {
                queue.offer(new Temp(temp.str + ")", temp.left, temp.right - 1));
            }
        }
        return ans;
    }


    public static class Temp {
        public String str;

        public int left;

        public int right;

        public Temp(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }
}
