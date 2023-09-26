import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        double[][] alphaNums = new double[26][14];
        boolean[] isValid = new boolean[26];

        int validCount = 0;

        for (int i = 0; i < T; i++) {
            char c = sc.next().charAt(0);
            int votes = sc.nextInt();
            if(votes <= N/20) continue;
            isValid[c - 'A'] = true;
            validCount++;
            for (int j = 0; j <= 13; j++) {
                double score = votes/(j+1.0);
                alphaNums[c - 'A'][j] = score;
            }
        }
        Double[] orderArray = new Double[validCount*14];
        int arrayIndex = 0;
        for (int i = 0; i < alphaNums.length; i++) {
            if(isValid[i]){
                for (int j = 0; j <= 13; j++) {
                    orderArray[arrayIndex++] = alphaNums[i][j];
                }
            }
        }
        Arrays.sort(orderArray, Collections.reverseOrder());
        Double[] coinArray = Arrays.copyOfRange(orderArray, 0 , 14);

        for (int i = 0; i < alphaNums.length; i++) {
            if(isValid[i]) {
                System.out.print((char) (i + 'A'));
                int coinCount = 0;

                for (int j = 0; j < alphaNums[i].length; j++) {
                    for (int k = 0; k < coinArray.length; k++) {
                        if(orderArray[k] == alphaNums[i][j]) coinCount++;
                    }
                }
                System.out.println(" " + coinCount);
            }
        }
    }
}