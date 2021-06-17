//  This is a basic example of hash function
//  Does not handle collisions

package data_structures.examples.hashtable;

public class Main {
    public static void main(String[] args) {
        
        SimpleHashTable hashTable = new SimpleHashTable();

        Employee janeJones = new Employee("Jane", "Jones", 2341);
        Employee johnDoe = new Employee("John", "Doe", 2323);
        Employee mikeWilson = new Employee("Mike", "Wilson", 2345);
        Employee marySmith = new Employee("Mary", "Smith", 2314);
        Employee billEnd = new Employee("Bill", "End", 2314);

        hashTable.put("Jones", janeJones);
        hashTable.put("Doe", johnDoe);
        hashTable.put("Wilson", mikeWilson);
        hashTable.put("Smith", marySmith);
        hashTable.put("End", billEnd);

        // hashTable.printHashTable();

        // System.out.println(hashTable.get("Wilson"));

        hashTable.remove("Wilson");
        hashTable.printHashTable();
    }
}
