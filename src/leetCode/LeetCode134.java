package leetCode;


import java.lang.management.GarbageCollectorMXBean;
import java.util.ConcurrentModificationException;

/**
 * @author acer
 * @Date 2019/9/2 12:02
 */
//加油站
public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0;
        int length = gas.length;
        //对每一个
        for (int i = 0; i < length; i++) {
            //从这个站出发都无法开到下一个站 肯定不行的
            if (gas[i] < cost[i]) {
                continue;
            } else {
                //总油量
                int sumGas = 0;
                int num = 0;
                int temp = i;
                ans = i;
                while (num < length) {
                    sumGas += gas[temp];
                    if (sumGas >= cost[temp]) {
                        sumGas -= cost[temp];
                    } else {
                        break;
                    }
                    num++;
                    temp++;
                    if (temp == length) {
                        temp = 0;
                    }
                }
                if (num == length) {
                    return ans;
                } else {
                    ans = 0;
                }
            }
        }
        return -1;
    }

    public int oneLoop(int[] gas, int[] cost) {
        int length = gas.length;

        int current_tank = 0;
        int total_tank = 0;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            total_tank += gas[i] - cost[i];
            current_tank += gas[i] - cost[i];
            if(current_tank < 0){
                current_tank = 0;
                ans = i+1;
            }
        }
        return total_tank >= 0? ans:-1;
    }

    public static void main(String[] args) {
        new LeetCode134().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
    }
}
