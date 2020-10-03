package com.xinzhe.categories.solutions.dfs.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/3/30 17:34
 * Title : 690. 员工的重要性
 * Description : 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 *              比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 *              现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 * link : https://leetcode-cn.com/problems/employee-importance
 * Level : Easy
 */

public class Leetcode690 {
    public int getImportance(List<Employee> employees, int id) {
        int res = 0;
        if(employees.size() == 0) return 0;
        Employee root = getEmployee(employees, id);
        if(root == null) return 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Employee cur = queue.poll();
                res += cur.importance;
                if(cur.subordinates != null){
                    for (Integer subordinate : cur.subordinates) {
                        if(getEmployee(employees, subordinate) != null){
                            queue.offer(getEmployee(employees, subordinate));
                        }
                    }
                }
            }
        }
        return res;
    }

    private Employee getEmployee(List<Employee> employees, int id) {
        Employee root = null;
        for (Employee employee : employees) {
            if(employee.id == id){
                root = employee;
                break;
            }
        }
        return root;
    }
}
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}