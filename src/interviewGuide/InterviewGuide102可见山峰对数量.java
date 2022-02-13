package interviewGuide;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/3
 */
public class InterviewGuide102可见山峰对数量 {

    /**
     * 无重复数字 所以除了最高的山峰和次高的山峰之外 每个山峰从两个方向总能找到两个可见山峰
     * 还有一对山峰是次高的山峰找最高的山峰 就是(nums-2)*2 + 1对山峰
     * @param peeks
     * @return
     */
    public static int getMountainsNum(int[] peeks){
        int peekNum = peeks.length;
        if (peekNum <= 1){
            return 0;
        }
        if (peekNum == 2){
            return 1;
        }
        return (peekNum-2) * 2 + 1;
    }
}
