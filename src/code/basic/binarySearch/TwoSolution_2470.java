package code.basic.binarySearch;

import java.io.*;
import java.util.Arrays;

public class TwoSolution_2470 {
    public static void main_2470(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Integer[] liquid = new Integer[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(liquid);

        int absMin = Integer.MAX_VALUE;
        int[] minResult = new int[2];
        for (int i = 0; i < N; i++) {
            Integer chk = liquid[i];

            int startIndex = i + 1;
            int endIndex = liquid.length -1;

            while(startIndex <= endIndex) {
                int chkIndex = (startIndex + endIndex) / 2;
                int chkSum = liquid[chkIndex] + chk;

                if(Math.abs(chkSum) < absMin) {
                    absMin = Math.abs(chkSum);
                    minResult[0] = chk;
                    minResult[1] = liquid[chkIndex];
                }

                if(chkSum < 0) {
                    startIndex = chkIndex + 1;
                }
                else if (chkSum > 0) {
                    endIndex = chkIndex - 1;
                }
                else break;
            }
        }

        bw.write(minResult[0] + " ");
        bw.write(minResult[1]+"");

        bw.flush();
    }
}
