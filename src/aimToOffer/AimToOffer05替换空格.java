package aimToOffer;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/2
 */
public class AimToOffer05替换空格 {
    /**
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' '){
                builder.insert(0,s.charAt(i));
            }else {
                builder.insert(0,"%20");
            }
        }
        return builder.toString();
    }
}
