package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/26
 */
public class LeetCode443压缩字符串 {

    /**
     * 暴力尝试
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        // 双指针
        int left = 0;
        int right = 0;
        while (left <= chars.length - 1 && right <= chars.length - 1) {
            int rightStart = right;
            while (right <= chars.length - 1 && chars[left] == chars[right]) {
                right++;
            }
            // 内循环遍历完了之后 chars[right]已经和chars[left]不同
            // 计算长度即为长度
            int num = right - rightStart;
            // 如果只有一个 则不需要处理
            if (num == 1) {
                left++;
            } else if (num < 10) {
                chars[left + 1] = (char) ('0' + num);
                left += 2;
            } else {
                String numStr = String.valueOf(num);
                for (int i = 0; i < numStr.length(); i++) {
                    chars[++left] = numStr.charAt(i);
                }
                left++;
            }
            if (right <= chars.length - 1) {
                chars[left] = chars[right];
            }
        }
        return left;
    }

    public static void main(String[] args) {
        char[] charArray = new char[]{'a', 'a', 'a', 'a', 'a', 'b'};
        int result = new LeetCode443压缩字符串().compress(charArray);
        System.out.println(result);
    }
}
