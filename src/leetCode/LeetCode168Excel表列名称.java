package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode168Excel表列名称 {

    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int i = 701;
        String result = new LeetCode168Excel表列名称().convertToTitle(i);
        System.out.println(result);
    }
}
