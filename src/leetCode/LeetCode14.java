package leetCode;

/**
 * @author acer
 * @Date 2019/7/23 17:30
 */
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//
//输入: ["flower","flow","flight"]
//输出: "fl"
//示例 2:
//
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//说明:
//
//所有输入只包含小写字母 a-z 。
public class LeetCode14 {
    //使用横向扫描法 对每一列的字符进行比较
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <= 0){
            return "";
        }
        String result = new String();
        for(int i = 0 ; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for(int j = 0; j<strs.length ; j++){
                if(i == strs[j].length() || strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
