package code.practice;

import java.io.IOException;
import java.util.Scanner;

public class BiggestSquare_1915 {
    public static void main_1915(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] acc = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char[] input = sc.next().toCharArray();
            for (int j = 1; j <= M; j++) {
                int value = input[j - 1] == '1' ? 1 : 0;
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + value;
            }
        }

        int minLength = Math.min(N, M);

        int startLength = 0;
        int endLength = minLength;
        int answerArea = 0;

        while (startLength <= endLength) {
            int chkLength = (startLength + endLength) / 2;
            if (isEnable(acc, chkLength)) {
                answerArea = chkLength * chkLength;
                startLength = chkLength + 1;
            } else {
                endLength = chkLength - 1;
            }
        }
        System.out.println(answerArea);
    }

    public static boolean isEnable(int[][] acc, int length) {
        for (int i = 1; i < acc.length - length + 1; i++) {
            for (int j = 1; j < acc[0].length - length + 1; j++) {
                if(acc[i + length -1][j + length -1] - acc[i-1][j + length -1] - acc[i + length -1][j-1] + acc[i-1][j-1] == length*length) return true;
            }
        }
        return false;
    }
}
