package code.practice;

import java.io.IOException;
import java.util.Scanner;

public class NumBaseBall_2503 {
    public static void main_2503(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] question = new int[N][3];
        for (int i = 0; i < N; i++) {
            question[i][0] = sc.nextInt();
            question[i][1] = sc.nextInt();
            question[i][2] = sc.nextInt();
        }

        int answer = 0;
        int chkNum = 123;
        while (chkNum <= 987) {
            if(!isValidNum(chkNum)) {
                chkNum++;
                continue;
            }
            boolean correct = true;
            for (int i = 0; i < question.length; i++) {
                if (!isCorrect(question[i][0], chkNum, question[i][1], question[i][2])) {
                    correct = false;
                    break;
                }
            }
            if (correct) answer++;
            chkNum++;

        }

        System.out.println(answer);
    }

    public static boolean isValidNum(int chkNum) {
        int num1 = chkNum / 100;
        int num2 = chkNum % 100 / 10;
        int num3 = chkNum % 10;
        if(num2 == 0 || num3 == 0) return false;
        return num1 != num2 && num2 != num3 && num3 != num1;
    }

    public static boolean isCorrect(int trial, int num, int strike, int ball) {
        char[] numChar = String.valueOf(num).toCharArray();
        char[] trialChar = String.valueOf(trial).toCharArray();

        int strikeChk = 0;
        for (int i = 0; i < 3; i++) {
            if (numChar[i] == trialChar[i]) strikeChk++;
        }

        int containChk = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (trialChar[i] == numChar[j]) containChk++;
            }
        }
        return strike == strikeChk && ball == containChk - strike;
    }
}
