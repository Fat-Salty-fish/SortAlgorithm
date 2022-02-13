package leetCode;

import others.NestedInteger;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/14
 */
public class LeetCode385迷你语法分析器 {

    /**
     * dfs处理
     *
     * @param s
     * @return
     */
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return new NestedInteger();
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        // 第一个符号为左括号 但是长度为2 说明是个空的值
        if (s.length() == 2) {
            return new NestedInteger();
        }
        NestedInteger result = new NestedInteger();
        int start = 1;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (count == 0 && (s.charAt(i) == ',' || i == s.length() - 1)) {
                result.add(deserialize(s.substring(start, i)));
                start = i + 1;
            }else if (s.charAt(i) == '['){
                count++;
            }else if (s.charAt(i) == ']'){
                count--;
            }
        }
        return result;
    }
}
