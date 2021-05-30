package data_structures.examples.vectors;

import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        List<Employee> employeeList = new Vector<>();

        employeeList.add(new Employee("Mary", "Jane", 3452));
        employeeList.add(new Employee("Harty", "Potter", 2413));
        employeeList.add(new Employee("Oliver", "Helden", 4426));
        employeeList.add(new Employee("Mike", "Williams", 5234));

        employeeList.forEach(employee -> System.out.println(employee));

    }
}
