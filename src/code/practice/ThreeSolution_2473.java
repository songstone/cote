package code.practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSolution_2473 {
    public static void main_2473(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] solutions = new int[N];
        for (int i = 0; i < N; i++) {
            solutions[i] = sc.nextInt();
        }

        Arrays.sort(solutions);

        int answer1 = solutions[0];
        int answer2 = solutions[1];
        int answer3 = solutions[2];

        long sum = Math.abs((long)answer1 + answer2 + answer3);

        for (int i = 0; i < N - 2; i++) {
            int startIndex = i+1;
            int endIndex = N-1;
            while (startIndex < endIndex) {
                long first = (long) solutions[i];
                long chkSum = first + solutions[startIndex] + solutions[endIndex];
                if(Math.abs(chkSum) < sum) {
                    answer1 = solutions[i];
                    answer2 = solutions[startIndex];
                    answer3 = solutions[endIndex];
                    sum = Math.abs(chkSum);
                }
                if(chkSum < 0) startIndex++;
                else endIndex--;
            }
        }

        System.out.println(answer1 + " " + answer2 + " " + answer3);
    }
}
