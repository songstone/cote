package code.basic.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BestSeller_1302 {
    public static void main_1302(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] sellLog = new String[N];

        for (int i = 0; i < N; i++) {
            sellLog[i] = sc.next();
        }

        Arrays.sort(sellLog);

        String bestSeller = sellLog[0];
        int maxSellCount = 1;
        int sellCount = 1;

        for (int i = 1; i < sellLog.length; i++) {
            if(!sellLog[i-1].equals(sellLog[i])) sellCount = 0;
            sellCount++;
            if(sellCount > maxSellCount) {
                bestSeller = sellLog[i];
                maxSellCount = sellCount;
            }
        }

        System.out.println(bestSeller);
    }
}
