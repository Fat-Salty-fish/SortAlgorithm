package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode171Excel列表序号 {

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char current = columnTitle.charAt(i);
            result = result * 26 + current - 'A' + 1;
        }
        return result;
    }
}
