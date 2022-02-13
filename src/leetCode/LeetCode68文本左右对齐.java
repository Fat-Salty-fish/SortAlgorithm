package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/19
 */
public class LeetCode68文本左右对齐 {

    /**
     * 简单模拟即可
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        while (true) {
            List<String> thisTimeStrings = new ArrayList<>();
            int thisTimeLength = 0;
            while (startIndex < words.length) {
                if ((thisTimeLength + words[startIndex].length() + thisTimeStrings.size() + 1 - 1) <= maxWidth) {
                    thisTimeLength += words[startIndex].length();
                    thisTimeStrings.add(words[startIndex++]);
                } else {
                    break;
                }
            }
            // 如果是最后一行 则靠左
            if (startIndex == words.length) {
                StringBuilder builder = new StringBuilder();
                builder.append(thisTimeStrings.get(0));
                for (int i = 1; i < thisTimeStrings.size(); i++) {
                    builder.append(" ").append(thisTimeStrings.get(i));
                }
                for (int i = 0, have = builder.length(); i < maxWidth - have; i++) {
                    builder.append(" ");
                }
                result.add(builder.toString());
                break;
            } else if (thisTimeStrings.size() == 1) {
                // 如果这一行只有一个单词 则靠左
                StringBuilder builder = new StringBuilder();
                builder.append(thisTimeStrings.get(0));
                for (int i = 0, have = builder.length(); i < maxWidth - have; i++) {
                    builder.append(" ");
                }
                result.add(builder.toString());
            } else {
                StringBuilder builder = new StringBuilder();
                // 这一行既不是最后一行 也不是只有一个单词 则左右对齐 把空格平均到每个单词之间
                int space = maxWidth - thisTimeLength;
                int sap = thisTimeStrings.size() - 1;
                int each = space / sap;
                int left = space - sap * each;
                for (int i = 0; i < thisTimeStrings.size(); i++) {
                    builder.append(thisTimeStrings.get(i));
                    if (i != thisTimeStrings.size() - 1) {
                        if (left > 0) {
                            for (int j = 0; j < each + 1; j++) {
                                builder.append(" ");
                            }
                            left--;
                        } else {
                            for (int j = 0; j < each; j++) {
                                builder.append(" ");
                            }
                        }
                    }
                }
                result.add(builder.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] array = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int num = 16;
        List<String> result = new LeetCode68文本左右对齐().fullJustify(array, 16);
        System.out.println(result.get(0));
    }
}
