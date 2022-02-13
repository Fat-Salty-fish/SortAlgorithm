package competition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/9
 */
public class LeetCode5978统计追加字母可以获得的单词数 {


    public int wordCount(String[] startWords, String[] targetWords) {
        if (startWords.length == 0) {
            return 0;
        }
        Set<String> startWordSet = new HashSet<>();
        for (String temp : startWords) {
            char[] charArray = temp.toCharArray();
            Arrays.sort(charArray);
            startWordSet.add(new String(charArray));
        }
        int result = 0;
        for (String targetWord : targetWords) {
            char[] targetCharArray = targetWord.toCharArray();
            Arrays.sort(targetCharArray);
            String tempString = new String(targetCharArray);
            for (int j = 0; j < targetCharArray.length; j++) {
                // 每个字母在字符串中只会出现一次
                String subString = tempString.substring(0, j) + tempString.substring(j + 1);
                if (startWordSet.contains(subString)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
