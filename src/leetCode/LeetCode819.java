package leetCode;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;


/**
 * @author acer
 * @Date 2019/5/3 10:51
 */
public class LeetCode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph.length()<1 || paragraph.length()>1000 || banned.length < 1 ||banned.length > 100){
            throw new IllegalArgumentException();
        }
        paragraph = paragraph.toLowerCase();
        Pattern pattern = Pattern.compile("\\s*[.,!?]\\s*");
        Matcher matcher = pattern.matcher(paragraph);
        paragraph = matcher.replaceAll(" ");
        String[] stringArray = paragraph.split(" ");
        //使用一个map用来存放每个单词以及他们出现的次数
        Map<String,Long> stringIntegerMap = Arrays.stream(stringArray).collect(Collectors.groupingBy(Function.identity(),counting()));
        String result = null;
        Set<String> ban = Arrays.stream(banned).collect(Collectors.toSet());
        for(Map.Entry<String,Long> entry:stringIntegerMap.entrySet()){
            if(!ban.contains(entry.getKey())){
                if(result == null){
                    result = entry.getKey();
                }else if(stringIntegerMap.get(result) <= entry.getValue()){
                    result = entry.getKey();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "a, a, a, a, b,b,b,c, c";
        String[] array = new String[]{"a"};
//        a = a.toLowerCase();
//        Pattern pattern = Pattern.compile("\\s*[.,!]\\s*");
//        Matcher matcher = pattern.matcher(a);
//        a = matcher.replaceAll(" ");
//        System.out.println(a);
        System.out.println(new LeetCode819().mostCommonWord(a,array));
    }

}
