package aimToOfferII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/6
 */
public class AimToOffer50第一个只出现一次的字符 {

    /**
     * 双指针即可解决
     * 双指针解决不了！
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Integer> count = new HashMap<>();
        for (Character temp : s.toCharArray()) {
            count.put(temp, count.getOrDefault(temp, 0) + 1);
        }
        Character result = ' ';
        for (Character temp:s.toCharArray()){
            if (count.get(temp) == 1){
                result = temp;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String test = "loveleetcode";
        char result = new AimToOffer50第一个只出现一次的字符().firstUniqChar(test);
    }
}
