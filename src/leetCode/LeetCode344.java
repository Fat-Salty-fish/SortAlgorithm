package leetCode;

/**
 * @author acer
 * @Date 2019/5/4 15:11
 */
public class LeetCode344 {
    /**
     * 反转字符串 要求必须在原字符串上进行改变 空间复杂度为O(1)
     * @param s
     */
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length-1;
        while (head<tail){
            char temp;
            temp = s[tail];
            s[tail] = s[head];
            s[head] = temp;

            ++head;
            --tail;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        new LeetCode344().reverseString(s);
        System.out.println(s);
    }
}
