package leetCode;

/**
 * @author acer
 * @Date 2019/5/3 10:04
 */
public class LeetCode709 {
    public String toLowerCase(String str) {
        if(str==null||str==""||str.length()==0){
            return null;
        }
        char[] array = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = 0 ;i<array.length; i++){
            if(array[i]>=65&&array[i]<=90){
                array[i]+=32;
            }
            result.append(array[i]);
        }
        return result.toString();
    }
}
