package code.basic.binarySearch;

import java.io.*;
import java.util.Arrays;

public class NumberCard2_10816 {
    public static void main_10816(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        String[] inputString = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(inputString[i]);
        }

        Arrays.sort(inputs);

        int T = Integer.parseInt(br.readLine());
        String[] chkInputString = br.readLine().split(" ");

        for (int i = 0; i < T; i++) {
            int chk = Integer.parseInt(chkInputString[i]);
            int upperBoundIndex = upperBoundIndex(inputs, chk);
            int lowerBoundIndex = lowerBoundIndex(inputs, chk);

            bw.write(upperBoundIndex - lowerBoundIndex + " ");
        }
        bw.flush();
    }

    public static int lowerBoundIndex(int[] inputs, int find) {
        int startIndex = 0;
        int endIndex = inputs.length - 1;
        int lowerBoundIndex = inputs.length;

        while(startIndex <= endIndex) {
            int chkIndex = (startIndex + endIndex) / 2;

            if(inputs[chkIndex] < find) startIndex = chkIndex + 1;
            else {
                lowerBoundIndex = chkIndex;
                endIndex = chkIndex - 1;
            }
        }

        return lowerBoundIndex;
    }

    public static int upperBoundIndex(int[] inputs, int find) {
        int startIndex = 0;
        int endIndex = inputs.length - 1;
        int lowerBoundIndex = inputs.length;

        while(startIndex <= endIndex) {
            int chkIndex = (startIndex + endIndex) / 2;

            if(inputs[chkIndex] <= find) startIndex = chkIndex + 1;
            else {
                lowerBoundIndex = chkIndex;
                endIndex = chkIndex - 1;
            }
        }

        return lowerBoundIndex;
    }
}
