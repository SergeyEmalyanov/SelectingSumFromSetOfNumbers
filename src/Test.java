import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //double[] inputArray = {10.10, 20.20, 30.30, 40.4, 50.5, 60.6, 70.7, 80.8, 90.9, 101.00};
        double [] inputArray={1,3,9,12,44,15,5,4,17,13,25,20,23,31,57,19,41};

        double inputSum = 89;
        SelectSum selectSum = new SelectSum(inputArray, inputSum);
        System.out.println("Количество комбинаций " + selectSum.quantityCombination());
        int sizeOfArrayList = selectSum.trueCombinations().size();
        ArrayList<byte[]> a = selectSum.trueCombinations();
        if (a.size()==2){
            double b=0;
            for (int i=0; i<a.get(0).length;i++) {
                b = b + a.get(0)[i];
            }
            if (b==0){
                System.out.println("Точных совпадений нет.");
                System.out.println("Максисальное совпадение:");
                double sum=0;
                for (int i=0; i<a.get(1).length;i++){
                    if (a.get(1)[i]==1) {
                        System.out.println(a.get(1)[i]*inputArray[i]);
                        sum+=a.get(1)[i]*inputArray[i];
                    }
                }
                System.out.println(sum);
                System.out.println(inputSum-sum);
            }
        }else {
            System.out.println("Количество совпадений: "+sizeOfArrayList);
            for (int i = 0; i < sizeOfArrayList; i++) {
                byte[] b = a.get(i);
                for (int j = 0; j < inputArray.length; j++) {
                    if (b[j]==1) {
                        System.out.println(b[j] * inputArray[j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
