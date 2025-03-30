package leetCode;

import java.util.*;

/**
 * @author acer
 * @Date 2019/7/27 9:08
 */
public class LeetCode690员工的重要性 {
    private class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    ;

    public int getImportance(List<Employee> employees, int id) {
        //重要度
        int myImportance = 0;
        for (Employee employee : employees) {
            //匹配到了目标员工的id
            if (employee.id == id) {
                //此人的重要度等于本人的重要度加每个人的重要度
                myImportance += employee.importance;
                for (Integer subId : employee.subordinates) {
                    myImportance += getImportance(employees, subId);
                }
            }
        }
        return myImportance;
    }


    /**
     * 二刷 BFS
     *
     * @param employees
     * @param id
     * @return
     */
    public int getImportance2(List<Employee> employees, int id) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, i);
        }
        Queue<Employee> queue = new LinkedList<Employee>();
        queue.offer(employees.get(map.get(id)));
        int result = 0;
        while (!queue.isEmpty()) {
            Employee currentEmployee = queue.poll();
            result += currentEmployee.importance;
            for (Integer subId : currentEmployee.subordinates) {
                queue.offer(employees.get(map.get(subId)));
            }
        }
        return result;
    }
}
