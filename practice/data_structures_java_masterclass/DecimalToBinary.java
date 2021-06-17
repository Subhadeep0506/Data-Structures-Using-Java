package practice.data_structures_java_masterclass;

public class DecimalToBinary {
    public static void main(String[] args) {
        
        System.out.println("binary of 27: " + new DecimalToBinary().decimalToBinary(27));
        
    }

    public int decimalToBinary(int n){

        if(n == 0){
            return 0;
        }
        return n % 2 + 10 * decimalToBinary(n / 2);
    }
}
