package code.basic.search;

import java.io.IOException;
import java.util.Scanner;

public class Arithmetic_11005 {
    public static void main_11005(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        String answer = "";
        while (N > 0) {
            int D = N % B;
            if(D < 10) answer += D;
            else answer += (char) (D - 10 + 'A');
            N = N / B;
        }

        for (int i = answer.length() - 1; i >= 0; i--) {
            System.out.print(answer.charAt(i));
        }
    }
}
