import java.util.ArrayList;

public class SelectSum {
    double [] setOfNumbers;
    double inputSum;
    double minOfCombination;
    byte [] arrayMinOfCombination;
    int counter;
    SelectSum (double [] setOfNumbers, double inputSum) {
        this.setOfNumbers=setOfNumbers;
        this.inputSum=inputSum;
        counter=setOfNumbers.length-1;
        minOfCombination=inputSum;
    }

    ArrayList <byte[]> trueCombinations (){
        ArrayList <byte[]> trueCombinations=new ArrayList<>();
        for (int i=1; i<=quantityCombination();i++) {
            double sumCombination = 0;
            byte[] a = Combination(i);
            for (int j =0; j <=counter; j++) {
                sumCombination += a[j] * setOfNumbers[j];
            }
            if (sumCombination == inputSum) {
                trueCombinations.add(a);
            } else {
                if (Math.abs(sumCombination - inputSum) < minOfCombination) {
                    minOfCombination = Math.abs(sumCombination - inputSum);
                    arrayMinOfCombination=a;
                }
            }
        }
        if (trueCombinations.isEmpty()) {
            byte [] a=new byte[counter+1];
            for (int i=0; i<=counter;i++) {
                a[i]=0;
            }
            trueCombinations.add(a);
            trueCombinations.add(arrayMinOfCombination);
        }
        return trueCombinations;
    }
    int quantityCombination () {
        int numberOfCombination=1;
        for (int i = 1; i<=setOfNumbers.length; i++) {
            numberOfCombination *= 2;
        }
        return numberOfCombination-1;
    }
    byte [] Combination (int combinationNumber) {
        int a=counter;
        byte[] combination = new byte[counter+1];
        while (true) {

            if (combinationNumber/2<1) {
                combination[a]=1;
                return combination;
                }
            if (combinationNumber==1){
                combination [a]=1;
                return combination;
            }
            if (combinationNumber%2>0){
                combination[a--]=1;
                combinationNumber=(combinationNumber-1)/2;
            }else{
                combinationNumber=combinationNumber/2;
                a--;
            }
        }

    }
}
