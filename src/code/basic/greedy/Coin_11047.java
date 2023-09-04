package code.basic.greedy;

import java.io.IOException;
import java.util.Scanner;

public class Coin_11047 {
    public static void main_11047(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coins = new int[N];
        int maxIndex = N-1;
        for (int i = 0; i < N; i++) {
            int coin = sc.nextInt();
            if(coin > K) {
                maxIndex = i-1;
                break;
            }
            coins[i] = coin;
        }

        int remain = K;
        int answer = 0;
        while(remain > 0) {
            int coin = coins[maxIndex--];
            int count = remain / coin;
            remain = remain % coin;
            answer += count;
        }

        System.out.println(answer);
    }
}
