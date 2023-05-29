package code.basic.search;

import java.util.Scanner;

public class Dice_1233 {
    public static void main_1233(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sumArray = new int[81];
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    int sum = i + j + k;
                    sumArray[sum]++;
                }
            }
        }

        int maxIndex = 0;
        int max = 0;

        for (int i = 0; i < sumArray.length; i++) {
            if(sumArray[i] > max) {
                maxIndex = i;
                max = sumArray[i];
            }
        }

        System.out.println(maxIndex);
    }
}
