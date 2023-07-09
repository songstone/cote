package code.basic.parametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CutLine_1654 {
    public static void main_1654(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] lines = new int[N];
        for (int i = 0; i < N; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        long startNum = 1;
        long endNum = (1L << 32) - 1;
        long maxValidNum = 1L << 32;

        while (startNum <= endNum) {
            long chkNum = (startNum + endNum) / 2;
            if (sumLineCut(lines, chkNum) < M) {
                endNum = chkNum - 1;
            } else {
                maxValidNum = chkNum;
                startNum = chkNum + 1;
            }
        }
        System.out.println(maxValidNum);
    }

    public static long sumLineCut(int[] lines, long div) {
        int sum = 0;
        for (int line : lines) {
            sum += line / div;
        }
        return sum;
    }
}
