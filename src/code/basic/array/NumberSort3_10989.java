package code.basic.array;

import java.io.*;

public class NumberSort3_10989 {
    public static void main_10989(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            cnt[index]++;
        }

        for (int i = 1; i <= 10000; i++) {
            while (cnt[i]-- > 0) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
