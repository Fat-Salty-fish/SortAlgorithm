package interviewGuide;


/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/1
 */
public class InterviewGuide92跳跃游戏 {

    /**
     * 跳跃游戏 计算能否到达最后一个下标
     *
     * @param array
     * @return
     */
    public int jumpNum(int[] array) {
        int max = 0;
        int jumpTime = 0;
        for (int i = 0; i < array.length; i++) {
            if (max >= i) {
                int current = array[i];
                if (current + i > max) {
                    max = current + i;
                    jumpTime += 1;
                    if (max >= array.length - 1) {
                        return jumpTime;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {3,2,3,1,1,4};
        int result = new InterviewGuide92跳跃游戏().jumpNum(array);
        System.out.println(result);
    }
}
