package data_structures.examples.maps;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        Map<String, String> map = new HashMap<String, String>();

        map.put("Father", "Subhendu");
        map.put("Mother", "Swapna");
        map.put("Brother", "Subhrajyoti");

        map.remove("Father");

        System.out.println(map.toString());
    }
}
