package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/17
 */
public class LeetCode551学生出勤记录I {

    /**
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int lNum = 0;
        int aNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == 'A'){
                aNum++;
                if (aNum >= 2){
                    return false;
                }
                lNum = 0;
            }else if (current == 'L'){
                lNum ++;
                if (lNum>=3){
                    return false;
                }
            }else {
                lNum = 0;
            }
        }
        return true;
    }
}
