package leetCode;

import java.util.*;

/**
 * @Author lizhongjie
 * @Date 2021/8/3
 * @Desc
 **/
public class LeetCode347前K个高频元素 {

    /**
     * 返回nums数组中出现频率前k个高的数字
     * 可以更优化一下 不用大顶堆 用小顶堆即可
     * 堆内仅维护k个频率的数即可
     * 用Map?
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int a : nums) {
            if (numMap.containsKey(a)){
                numMap.put(a,numMap.get(a)+1);
            }else {
                numMap.put(a,1);
            }
        }
        // 有序队列 对频率进行排序
        Queue<Integer> orderedQueue = new PriorityQueue<>(Collections.reverseOrder());
        // 保存了出现频率和数字 并将频率保存到有序队列里
        Map<Integer,List<Integer>> reverse = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            List<Integer> temp = reverse.get(entry.getValue());
            if (temp == null){
                temp = new ArrayList<>();
            }
            temp.add(entry.getKey());
            reverse.put(entry.getValue(), temp);
        }
        for (Map.Entry<Integer, List<Integer>> entry : reverse.entrySet()) {
            orderedQueue.add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; ) {
            List<Integer> temp = reverse.get(orderedQueue.poll());
            for (int value : temp) {
                if (i < k) {
                    result.add(value);
                    i++;
                } else {
                    break;
                }
            }
        }
        Integer[] temp = result.toArray(new Integer[0]);
        int[] res = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            res[i] = temp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int k = 10;
        int[] res = new LeetCode347前K个高频元素().topKFrequent(array,k);
        System.out.println("a");
    }
}
