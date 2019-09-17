package leetCode;

import javax.servlet.jsp.el.ImplicitObjectELResolver;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/27 9:08
 */
public class LeetCode690 {
    private class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        //重要度
        int myImportance = 0;
        for(Employee employee:employees){
            //匹配到了目标员工的id
            if(employee.id == id){
                //此人的重要度等于本人的重要度加每个人的重要度
                myImportance  += employee.importance;
                for(Integer subId : employee.subordinates){
                    myImportance += getImportance(employees,subId);
                }
            }
        }
        return myImportance;
    }
}
