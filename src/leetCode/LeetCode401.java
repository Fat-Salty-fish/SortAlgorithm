package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/8 20:28
 */
public class LeetCode401 {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if(Integer.bitCount(hour)+Integer.bitCount(minute) == num){
                    ans.add(String.format("%d:%02d",hour,minute));
                }
            }
        }
        return ans;
    }

}
