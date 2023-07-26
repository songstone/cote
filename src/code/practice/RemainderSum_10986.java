package code.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemainderSum_10986 {
    public static void main_10986(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        long[] acc = new long[N + 1];
        int[] remainderCnt = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 0; i--) {
            int remainder = (int) (acc[i] % M);
            remainderCnt[remainder]++;
        }

        long answer = 0;
        for (int i = 0; i < M; i++) {
            answer += (long)remainderCnt[i] * (remainderCnt[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}
