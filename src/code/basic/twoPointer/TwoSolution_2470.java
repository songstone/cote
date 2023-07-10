package code.basic.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSolution_2470 {
    public static void main_2470(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] liquid = new int[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(liquid);

        int absMin = Integer.MAX_VALUE;
        int[] result = new int[2];

        int startIndex = 0;
        int endIndex = liquid.length -1;

        while(startIndex < endIndex) {
            int chkSum = liquid[startIndex] + liquid[endIndex];
            if(Math.abs(chkSum) < absMin) {
                absMin = Math.abs(chkSum);
                result[0] = liquid[startIndex];
                result[1] = liquid[endIndex];
            }

            if(chkSum < 0) startIndex++;
            else if (chkSum > 0) endIndex--;
            else break;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
