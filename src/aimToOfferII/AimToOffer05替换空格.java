package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/26
 */
public class AimToOffer05替换空格 {



    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == ' '){
                builder.append("%20");
            }else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

}
