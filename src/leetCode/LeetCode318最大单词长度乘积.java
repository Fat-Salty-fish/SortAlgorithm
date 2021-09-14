package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/9
 */
public class LeetCode318最大单词长度乘积 {

    /**
     * 最大单词长度乘积
     * 先暴力法吧
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        // 用于保存长度
        int[] lengthArray = new int[words.length];
        // 用于保存每个字符串的字母位是否存在
        int[] bitMapArray = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lengthArray[i] = words[i].length();
            int map = 0;
            for (char ch : words[i].toCharArray()) {
                map |= 1 << bitInt(ch);
            }
            bitMapArray[i] = map;
        }


        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitMapArray[i] & bitMapArray[j]) == 0) {
                    max = Math.max(max,lengthArray[i] * lengthArray[j]);
                }
            }
        }
        return max;
    }

    public int bitInt(char ch) {
        return (int) ch - (int) 'a';
    }
}
