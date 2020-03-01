package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class OrganizationStructure {
  private Map<String, Employee> employeeMap = new HashMap<>();
  private Map<Integer, Employee> rootManagers = new TreeMap<>();
  private int time = 0;

  public static void main(String[] args) {
    OrganizationStructure o = new OrganizationStructure();
    o.add("1", "S", "-1");
    o.add("5", "D", "1");
    o.add("8", "L", "-1");
    o.add("9", "L1", "8");
    o.add("6", "F", "1");
    System.out.println(o.count("1"));
//    o.remove("8");
    o.print();
  }

  public void add(String id, String name, String managerId) {
    Employee employee = new Employee(id, name, managerId, time);
    employeeMap.put(id, employee);
    if (managerId.equals("-1")) {
      rootManagers.put(time, employee);
    }
    time++;
  }

  public void remove(String id) {
    Employee employee = employeeMap.get(id);
    employeeMap.remove(id);
    for (Employee e : employeeMap.values()) {
      if (e.managerId.equals(id)) {
        e.managerId = employee.managerId;
        if (e.managerId.equals("-1")) {
          rootManagers.put(e.time, e);
        }
      }
    }
    for (int t : rootManagers.keySet()) {
      if (rootManagers.get(t).id.equals(id)) {
        rootManagers.remove(t);
        break;
      }
    }
  }

  public void update(String employeeId, String newManagerId) {
    employeeMap.get(employeeId).managerId = newManagerId;
    if (newManagerId.equals("-1")) {
      rootManagers.putIfAbsent(employeeMap.get(employeeId).time, employeeMap.get(employeeId));
    }
  }

  public int count(String employeeId) {
    Map<String, Set<Employee>> map = getManagerMap();
    return searchAndCount(map, employeeId);
  }

  public void print() {
    Map<String, Set<Employee>> map = getManagerMap();
    for (Employee employee : rootManagers.values()) {
      print(employee, map, "");
    }
  }

  private void print(Employee employee, Map<String, Set<Employee>> map, String spaces) {
    System.out.println(spaces + employee);
    if (map.containsKey(employee.id)) {
      List<Employee> employees = new ArrayList<>(map.get(employee.id));
      Collections.sort(employees);
      for (Employee e : employees) {
        print(e, map, spaces + "  ");
      }
    }
  }

  private int searchAndCount(Map<String, Set<Employee>> map, String employeeId) {
    int ans = 1;
    for (Employee employee : map.getOrDefault(employeeId, new HashSet<>())) {
      ans = ans + searchAndCount(map, employee.id);
    }
    return ans;
  }

  private Map<String, Set<Employee>> getManagerMap() {
    Map<String, Set<Employee>> map = new HashMap<>();
    for (String id : employeeMap.keySet()) {
      Employee employee = employeeMap.get(id);
      map.putIfAbsent(employee.managerId, new HashSet<>());
      map.get(employee.managerId).add(employee);
    }
    return map;
  }

  private static class Employee implements Comparable<Employee> {
    String id;
    String name;
    String managerId;
    int time;

    public Employee(String id, String name, String managerId, int time) {
      this.id = id;
      this.name = name;
      this.managerId = managerId;
      this.time = time;
    }

    @Override
    public String toString() {
      return name + " [" + id + "]";
    }

    @Override
    public int compareTo(Employee o) {
      return this.time - o.time;
    }
  }
}
