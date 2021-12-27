package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/4
 */
public class LeetCode383赎金信 {


    /**
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineHaveChars = new HashMap<>();
        for (Character current : magazine.toCharArray()) {
            magazineHaveChars.put(current, magazineHaveChars.getOrDefault(current, 0) + 1);
        }
        for (Character current : ransomNote.toCharArray()) {
            if (!magazineHaveChars.containsKey(current)){
                return false;
            }
            Integer num = magazineHaveChars.get(current);
            if (num <=0){
                return false;
            }
            magazineHaveChars.put(current,num-1);
        }
        return true;
    }
}
