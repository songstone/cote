package code.practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EatEaten_7795 {
    public static void main_7795(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            Integer[] arrN = new Integer[N];
            Integer[] arrM = new Integer[M];

            for (int i = 0; i < N; i++) {
                arrN[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                arrM[i] = sc.nextInt();
            }

            Arrays.sort(arrN, (i1, i2) -> i2 - i1);
            Arrays.sort(arrM, (i1,i2) -> i2 - i1);

            int indexN = 0;
            int indexM = 0;

            int answer = 0;
            while(indexN < arrN.length && indexM < arrM.length) {
                if(arrN[indexN] <= arrM[indexM]) indexM++;
                else {
                    answer += arrM.length - indexM;
                    indexN++;
                }
            }
            System.out.println(answer);
        }
    }
}
