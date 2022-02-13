package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/19
 */
public class LeetCode271字符串的编码与解码 {

    static public class Codec {

        public String intToString(String s) {
            int length = s.length();
            char[] num = new char[4];
            for (int i = 3; i >= 0; i--) {
                num[3 - i] = (char) (length >> (8 * i) & 0xff);
            }
            return new String(num);
        }

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < strs.size(); i++) {
                builder.append(intToString(strs.get(i)));
                builder.append(strs.get(i));
            }
            return builder.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> result = new ArrayList<>();
            int index = 0;
            while (index < s.length()) {
                String nums = s.substring(index, index + 4);
                int length = stringToInt(nums);
                index += 4;
                result.add(s.substring(index, index + length));
                index += length;
            }
            return result;
        }

        /**
         * 将字符串转换为数字
         *
         * @param s
         * @return
         */
        public int stringToInt(String s) {
            char[] array = s.toCharArray();
            int result = 0;
            for (int i = 3; i >= 0; i--) {
                result |= (array[i]) << (8 * (3 - i));
            }
            return result;
        }

    }

    /**
     * 用特殊字符解决
     */
    static public class CodecWithChar {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if (strs.isEmpty()) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            builder.append(strs.get(0));
            for (int i = 1; i < strs.size(); i++) {
                builder.append((char) 257);
                builder.append(strs.get(i));
            }
            return builder.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> result = new ArrayList<>();
            if (s.isEmpty()) {
                result.add("");
                return result;
            }
            int index = 0;
            StringBuilder builder = new StringBuilder();
            while (index < s.length()) {
                if (s.charAt(index) == (char) 257) {
                    result.add(builder.toString());
                    builder = new StringBuilder();
                } else {
                    builder.append(s.charAt(index));
                }
                index++;
            }
            result.add(builder.toString());
            return result;
        }
    }

    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";
        List<String> stringList = new ArrayList<>();
        stringList.add("");
        String result = new CodecWithChar().encode(stringList);
        List<String> decode = new CodecWithChar().decode(result);
        System.out.println(result);
    }
}
