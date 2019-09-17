package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.spi.CurrencyNameProvider;

/**
 * @author acer
 * @Date 2019/8/9 0:03
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        int length = digits.length();
        List<List<Character>> fullChars = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            fullChars.add(findLetter(digits.charAt(i)));
        }
        build(ans, fullChars, 0, length, digits, new Stack<Character>());
        return ans;

    }

    public void build(List<String> ans, List<List<Character>> fullChars, int currSize, int size, String digits, Stack<Character> path) {
        if (currSize == size) {
            List<Character> cur = new ArrayList<>(path);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < cur.size(); i++) {
                builder.append(cur.get(i));
            }
            ans.add(builder.toString());
            return;
        }
        for(int i = 0 ; i<fullChars.get(currSize).size();i++) {
            path.push(fullChars.get(currSize).get(i));
            build(ans, fullChars, currSize + 1, size, digits, path);
            path.pop();
        }
    }

    public List<Character> findLetter(char num) {
        List<Character> ans = null;
        switch (num) {
            case '2':
                ans = Arrays.asList('a', 'b', 'c');
                break;
            case '3':
                ans = Arrays.asList('d', 'e', 'f');
                break;
            case '4':
                ans = Arrays.asList('g', 'h', 'i');
                break;
            case '5':
                ans = Arrays.asList('j', 'k', 'l');
                break;
            case '6':
                ans = Arrays.asList('m', 'n', 'o');
                break;
            case '7':
                ans = Arrays.asList('p', 'q', 'r', 's');
                break;
            case '8':
                ans = Arrays.asList('t', 'u', 'v');
                break;
            case '9':
                ans = Arrays.asList('w', 'x', 'y', 'z');
                break;
            default:
                ans = new ArrayList<>();
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        String current = new String("23");
        List<String> ans = new LeetCode17().letterCombinations(current);
        for (String a : ans) {
            System.out.println(a);
        }
    }
}
