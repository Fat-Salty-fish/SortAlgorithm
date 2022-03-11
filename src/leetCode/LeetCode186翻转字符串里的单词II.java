package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/2
 */
public class LeetCode186翻转字符串里的单词II {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int startIndex = 0;
        while (startIndex < s.length) {
            if (s[startIndex] == ' ') {
                startIndex++;
            }
            int endIndex = startIndex;
            while (endIndex < s.length && s[endIndex] != ' ') {
                endIndex++;
            }
            reverse(s, startIndex, endIndex - 1);
            startIndex = endIndex;
        }
    }

    /**
     * 反转startIndex 和 endIndex之间的字符
     *
     * @param s
     * @param startIndex
     * @param endIndex
     */
    public void reverse(char[] s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char temp = s[startIndex];
            s[startIndex] = s[endIndex];
            s[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        char[] array = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        new LeetCode186翻转字符串里的单词II().reverseWords(array);
        System.out.println(array[0]);
    }
}
