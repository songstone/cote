package code.basic.prefixSum;

import java.io.IOException;
import java.util.Scanner;

public class BootCamp_19951 {
    public static void main_19951(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        int[] origin = new int[N+1];
        for (int i = 1; i <= N; i++) {
            origin[i] = sc.nextInt();
        }

        int[] delta = new int[N+2];
        while(T-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int amount = sc.nextInt();

            delta[start] += amount;
            delta[end + 1] -= amount;
        }

        int[] deltaSum = new int[N+2];
        for (int i = 1; i < deltaSum.length; i++) {
            deltaSum[i] = deltaSum[i-1] + delta[i];
        }

        for (int i = 1; i < origin.length; i++) {
            System.out.print(origin[i] + deltaSum[i] + " ");
        }
    }
}
