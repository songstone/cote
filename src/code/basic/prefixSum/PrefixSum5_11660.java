package code.basic.prefixSum;

import java.io.*;

public class PrefixSum5_11660 {
    public static void main_11660(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int T = Integer.parseInt(inputs[1]);

        int[][] sumArray = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j < N + 1; j++) {
                sumArray[i][j] = sumArray[i][j - 1]
                    + sumArray[i - 1][j]
                    - sumArray[i - 1][j - 1]
                    + Integer.parseInt(input[j-1]);
            }
        }

        while (T-- > 0) {
            String[] testCase = br.readLine().split(" ");
            int start1 = Integer.parseInt(testCase[0]);
            int start2 = Integer.parseInt(testCase[1]);
            int end1 = Integer.parseInt(testCase[2]);
            int end2 = Integer.parseInt(testCase[3]);

            int result = sumArray[end1][end2]
                - sumArray[start1 - 1][end2]
                - sumArray[end1][start2 - 1]
                + sumArray[start1 - 1][start2 - 1];

            bw.write(result + "\n");
        }
        bw.flush();
    }
}
