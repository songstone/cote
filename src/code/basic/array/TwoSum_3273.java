package code.basic.array;

import java.io.IOException;
import java.util.Scanner;

public class TwoSum_3273 {
    public static void main_3273(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        int X = sc.nextInt();

        boolean[] exist = new boolean[1000001];
        for (int i = 0; i < N; i++) {
            exist[array[i]] = true;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int pair = X - array[i];
            if(0 <= pair && pair <= 1000000)
                answer += exist[pair] ? 1 : 0;
        }
        System.out.println(answer / 2);
    }
}
