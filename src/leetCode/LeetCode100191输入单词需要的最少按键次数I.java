package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/1/21
 */
public class LeetCode100191输入单词需要的最少按键次数I {

    public int minimumPushes(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        int num = word.length();
        int result = 0;
        int posi = 1;
        while (num > 0) {
            if (num >= 8) {
                result += 8 * posi;
                num = num - 8;
            } else {
                result += posi * num;
                break;
            }
            posi++;
        }
        return result;
    }
}
