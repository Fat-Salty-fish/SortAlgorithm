package interviewGuide;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/3
 */
public class InterviewGuide105可见山峰对数量2进阶 {


    /**
     * 无重复数字 所以除了最高的山峰和次高的山峰之外 每个山峰从两个方向总能找到两个可见山峰
     * 还有一对山峰是次高的山峰找最高的山峰 就是(nums-2)*2 + 1对山峰
     *
     * @param peeks
     * @return
     */
    public int getMountainsNum(int[] peeks) {
        // 单调递增栈
        Deque<Record> max = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < peeks.length; i++) {
            int currentPeek = peeks[i];
            while (!max.isEmpty()) {
                if (currentPeek == max.peek().peek) {
                    max.peek().count++;
                    break;
                } else if (currentPeek < max.peek().peek) {
                    Record temp = new Record();
                    temp.peek = currentPeek;
                    temp.count = 1;
                    max.push(temp);
                    break;
                } else {

                }
            }
        }
        return 0;
    }


    /**
     * 记录山峰高度和数量
     */
    public class Record {

        public int peek;

        public int count;

    }
}
