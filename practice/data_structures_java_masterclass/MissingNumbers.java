//  Incomplete

package practice.data_structures_java_masterclass;

import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] array = {1,2,3,5,6,8,9,11,12,13,14,17,18};

        List<Integer> missing = missingNumbers(array);

        for (int i : missing) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> missingNumbers(int[] array){
        
        List<Integer> missing = new ArrayList<>();
        int next = array[0] + 1;
        for (int i = 1; i < array.length; i++){
            
            if(array[i] != next){
                missing.add(next);
                next++;
            }
            next++;
        }

        return missing;
    }
}
