package interviewGuide;

import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/18
 */
public class InterviewGuide187派对的最大快乐值 {


    /**
     * 计算派对的最大快乐值
     *
     * @param employee
     * @return
     */
    public int happy(Employee employee) {
        ReturnType result = happyCalculate(employee);
        return Math.max(result.existHappy, result.notExistHappy);
    }

    public ReturnType happyCalculate(Employee employee) {
        if (employee == null) {
            return new ReturnType(0, 0);
        }
        int existHappy = employee.happy;
        int notExistHappy = 0;
        for (Employee temp : employee.subordinates) {
            ReturnType returnType = happyCalculate(temp);
            existHappy += returnType.notExistHappy;
            notExistHappy += returnType.existHappy;
        }
        return new ReturnType(existHappy, notExistHappy);
    }


    public class ReturnType {

        /**
         * 如果当前员工去 所有下属的快乐值
         */
        public int existHappy;

        /**
         * 如果当前员工不去 所有下属的快乐值
         */
        public int notExistHappy;

        public ReturnType(int existHappy, int notExistHappy) {
            this.existHappy = existHappy;
            this.notExistHappy = notExistHappy;
        }
    }


    public class Employee {

        /**
         * 员工快乐值
         */
        public int happy;

        /**
         * 下属员工
         */
        public List<Employee> subordinates;
    }

}



