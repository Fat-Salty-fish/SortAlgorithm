package leetCode;

/**
 * @author acer
 * @Date 2019/8/26 20:34
 */
public class LeetCode6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int len = Math.min(s.length(), numRows);
        String[] array = new String[len];
        for(int i = 0;i<array.length;i++){
            array[i] =  "";
        }
        //down 表示是否向下遍历
        boolean down = false;
        //loc表示当前输入的字符串的index
        int loc = 0;

        for (int i = 0; i < s.length(); i++) {
            array[loc] += s.charAt(i);
            //当前处理的字符串是最后一个字符串或者是第一个字符串的时候进行方向的反转
            if (loc == 0 || loc == numRows - 1) {
                down = !down;
            }
            loc += down ? 1 : -1;
        }
        String ans = "";
        for(String a:array){
            ans+=a;
        }
        return ans;
    }
}
