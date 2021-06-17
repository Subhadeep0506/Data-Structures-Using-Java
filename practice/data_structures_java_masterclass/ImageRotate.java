package practice.data_structures_java_masterclass;

public class ImageRotate {
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 3}, 
                          {2, 3, 5},
                          {3, 7, 2}};

        for(int i = 0; i < matrix.length; i++){

            for(int j = 0; j < matrix[0].length; j++){

                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        } 

        rotateMatrix(matrix);
        System.out.println();
        for(int i = 0; i < matrix.length; i++){

            for(int j = 0; j < matrix[0].length; j++){

                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }                 
    }

    public static boolean rotateMatrix(int[][] matrix){

        if(matrix.length == 0 || matrix.length != matrix[0].length)
            return false;

        int n = matrix.length;
        for( int layer = 0; layer < n / 2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++){
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        } 
        return true;   
    }
}
