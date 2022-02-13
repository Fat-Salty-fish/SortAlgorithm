package leetCode;

import java.util.*;

/**
 * @author acer
 * @Date 2019/8/26 16:28
 */
public class LeetCode950按递增顺序显示卡牌 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int length = deck.length;
        List<Integer> array = new LinkedList<>();
        for (int i = 0; i < length; i++) {
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


    /**
     * 微软模拟面试 二刷
     * 看了半天题解才看明白 ...就是按照结果想要的顺序 将数组元素放到指定位置去
     * 然后这个指定位置就是和题目的要求顺序一样的 所以模拟一次即可
     * 用队列即可完成
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing2(int[] deck) {
        int N = deck.length;
        Queue<Integer> index = new LinkedList<>();
        for (int i = 0; i < N; ++i) {
            index.add(i);
        }

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card : deck) {
            ans[index.poll()] = card;
            if (!index.isEmpty()) {
                index.add(index.poll());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new LeetCode950按递增顺序显示卡牌().deckRevealedIncreasing2(new int[]{17, 13, 11, 2, 3, 5, 7});
    }
}
