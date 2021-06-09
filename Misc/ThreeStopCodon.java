package Misc;

public class ThreeStopCodon {
    
    public String findGene(String dna){
        
        int startIndex = dna.indexOf("ATG");

        if (startIndex == -1){
            return "";
        }
        int taaindex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagindex = findStopCodon(dna, startIndex, "TAG");

        int minIndex = Math.min(Math.min(taaindex, tgaIndex), tagindex);
        if(minIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }

    public int findStopCodon(String dnaString, int startIndex, String stopCodon){
        
        int curIndex = dnaString.indexOf(stopCodon, startIndex + 3);
        
        if(curIndex != -1){

            if((curIndex - startIndex) % 3 == 0){

                return curIndex;
            }
            else{

                curIndex = dnaString.indexOf(stopCodon, curIndex + 1);
            }
        }
        return dnaString.length();
    }

    public static void main(String[] args) {
        


    }

}
