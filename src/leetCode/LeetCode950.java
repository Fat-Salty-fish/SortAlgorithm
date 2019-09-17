package leetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/26 16:28
 */
public class LeetCode950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int length = deck.length;
        List<Integer> array = new LinkedList<>();
        for(int i = 0;i<length;i++){
            //里面存放了位置 索引
            array.add(i);
        }
        int[] ans = new int[length];
        //经过排序之后这个数组已经是有序的了
        Arrays.sort(deck);
        //根据序列进行抽取
        for (int card : deck) {

            ans[((LinkedList<Integer>) array).pollFirst()] = card;
            //如果不为空 则将现在的第一张牌抽出来放到最底下
            if (!array.isEmpty()) {
                array.add(((LinkedList<Integer>) array).pollFirst());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode950().deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7});
    }
}
