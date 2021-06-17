package data_structures.examples.hashtable;

public class SimpleHashTable {
    
    private StoredEmployee[] hashTable;

    public SimpleHashTable(){

        hashTable = new StoredEmployee[10];
    }
    
    public void put(String key, Employee employee){
        
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)){
            int stopIndex = hashedKey;
            if(hashedKey == hashTable.length)
                hashedKey = 0;
            else
                hashedKey++;

            while(occupied(hashedKey) && hashedKey != stopIndex){

                hashedKey = (hashedKey + 1) % hashTable.length;
            }        
        }

        if(occupied(hashedKey)){
            System.out.println("Sorry! The position if filled");
        }
        else{
            hashTable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key){

        int hashedKey = findKey(key);

        if(hashedKey == -1)
            return null; 
        return hashTable[hashedKey].employee;
    }

    private int hashKey(String key){

        return key.length() % hashTable.length;
    }

    private int findKey(String key){

        int hashedKey = hashKey(key);

        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)){

            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashTable.length)
            hashedKey = 0;
        else
            hashedKey++;

        while (hashedKey != stopIndex && 
                hashTable[hashedKey] != null && 
                    !hashTable[hashedKey].equals(key))

            hashedKey = (hashedKey + 1) % hashTable.length;

        if(hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key))
            return hashedKey;
        else
            return -1;    
               
    }

    public boolean occupied(int index){
        return hashTable[index] != null;
    }
    
    public void printHashTable(){

        for (StoredEmployee employee : hashTable) {

            if(employee == null)
                System.out.println("empty");

            else    
                System.out.println(employee.employee);
        }
    }

    public Employee remove(String key){

        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }
        
        Employee employee = hashTable[hashedKey].employee;
        hashTable[hashedKey] = null;
        return employee;
    }

}
