package Misc;

public class GeneCodon {
    
    public static void main(String[] args) {
        
        // String dna = "AATGCTAGGGTAATATGGT";
        // String dna = "AGATGCGATACGCTTAATC";
        String dna = "CGTAGTATGCGTGCTAA";

        GeneCodon geneCodon = new GeneCodon();

        System.out.println("Gene: " + geneCodon.findDnaFromString(dna));
    }

    public String findDnaFromString(String dna){

        String gene = "", start = "ATG", end = "TAA";
        if(dna.indexOf(end) == -1 || dna.indexOf(start) == -1){

            gene = "";
        }
        else if((dna.indexOf(end) - dna.indexOf(start)) % 3 == 0){

            return dna.substring(dna.indexOf(start), dna.indexOf(end) + 3);
        }
        else{
            gene = "";
        }
        return gene;
    }
}
