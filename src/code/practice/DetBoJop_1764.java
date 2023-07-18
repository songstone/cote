package code.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DetBoJop_1764 {
    public static void main_1764(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] input = new String[N + M];
        for (int i = 0; i < input.length; i++) {
            input[i] = br.readLine();
        }

        Arrays.sort(input);

        int count = 0;
        String[] answer = new String[M];
        for (int i = 0; i < input.length - 1; i++) {
            if(input[i].equals(input[i+1])) {
                answer[count++] = input[i];
            }
        }

        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(answer[i]);
        }
    }
}
