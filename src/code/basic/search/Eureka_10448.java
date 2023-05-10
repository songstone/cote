package code.basic.search;

import java.util.Scanner;

public class Eureka_10448 {
    static boolean[] isEureka = new boolean[1001];

    public static void preProcess() {
        int[] triNums = new int[50];
        int triNumCount = 0;
        for (int i = 1; ; i++) {
            int triNum = i * (i + 1) / 2;
            if (triNum >= 1000) break;
            triNums[triNumCount++] = triNum;
        }

        boolean[] isTriSum = new boolean[1001];
        for (int i = 0; i < triNumCount; i++) {
            for (int j = 0; j < triNumCount; j++) {
                int sum = triNums[i] + triNums[j];
                if (sum < 1000) isTriSum[sum] = true;
            }
        }

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < triNumCount; j++) {
                if (!isTriSum[i]) continue;
                int chk = i + triNums[j];
                if (chk <= 1000) isEureka[chk] = true;
            }
        }
    }

    public static void main_10448(String[] args) {
        preProcess();

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();

            System.out.println(isEureka[K] ? 1 : 0);
        }
    }
}
