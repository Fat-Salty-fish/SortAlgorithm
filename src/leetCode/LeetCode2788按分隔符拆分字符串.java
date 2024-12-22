package leetCode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/1/20
 */
public class LeetCode2788按分隔符拆分字符串 {


    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        if (words == null || words.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (String a : words) {
            for (int i = 0; i < a.length(); i++) {
                if (separator != a.charAt(i)) {
                    builder.append(a.charAt(i));
                } else {
                    if (builder.length() != 0) {
                        result.add(builder.toString());
                        builder = new StringBuilder();
                    }
                }
            }
            if (builder.length() != 0) {
                result.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        return result;
    }
}
