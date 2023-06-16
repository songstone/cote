package code.basic.prefixSum;

import java.io.IOException;
import java.util.Scanner;

public class GenericQueries_16713 {
    public static void main_16713(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();

        int[] acc = new int[N+1];

        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i-1] ^ sc.nextInt();
        }

        int answer = 0;
        while(T-- > 0) {
            int startIndex = sc.nextInt();
            int endIndex = sc.nextInt();
            answer ^= acc[endIndex] ^ acc[startIndex - 1];
        }
        System.out.println(answer);
    }
}
