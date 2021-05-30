package data_structures.examples.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        //Creating four objects and initializing them
        employeeList.add(new Employee("Mary", "Jane", 3452));
        employeeList.add(new Employee("Harty", "Potter", 2413));
        employeeList.add(new Employee("Oliver", "Helden", 4426));
        employeeList.add(new Employee("Mike", "Williams", 5234));

        //Displaying list contents using lambda expression
        //employeeList.forEach(employee -> System.out.println(employee));

        //System.out.println(employeeList.get(2));

        //Replaces element at position 1 with the new element
        //employeeList.set(1, new Employee("Boris", "Chuck", 3423));
        //employeeList.forEach(employee -> System.out.println(employee));

        System.out.println("Size of list: " + employeeList.size());

        //Adding an element at index 2
        employeeList.add(2, new Employee("Boris", "Chuck", 3413));

        //Converting the list to an array an storing it to employeeArray
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]); //This is an Object array

        for(Employee employee: employeeArray){
            System.out.println(employee);
        }

        //To check for instances in the array, we can call the contains() method
        System.out.println(employeeList.contains(new Employee("Oliver", "Helden", 4426)));
        /*
         * If there is no equals() method in Employee class, the output will be false
         * Because, inside contains(), we have created a new instance of Employee
         * which is different from the initial instance
         * Hence, thought the latter instance is structurally same as the initial instance
         * the output will be false.
         *
         * So, creating an overloaded equals() method in Employee class does the work
         */

        //Similarly, indexOf() method would not work if we don't have a equals method in Employee class
        System.out.println(employeeList.indexOf(new Employee("Boris", "Chuck", 3413)));

        //Removing element
        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));


    }
}
