package code.basic.twoPointer;

import java.io.IOException;
import java.util.Scanner;

public class DnaPassword_12891 {
    public static void main_12891(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();

        char[] input = sc.next().toCharArray();

        int[] chkArray = new int[4];
        for (int i = 0; i < 4; i++) {
            chkArray[i] = sc.nextInt();
        }

        int answer = 0;

        int[] numArray = new int[4];
        for (int i = 0; i < P; i++) {
            char ch = input[i];
            numArray[getIndex(ch)]++;
        }
        if(isCorrect(chkArray, numArray)) answer++;

        int startIndex = 0;
        int endIndex = P-1;

        while(endIndex < N-1) {
            char chSub = input[startIndex++];
            char chAdd = input[++endIndex];
            numArray[getIndex(chSub)]--;
            numArray[getIndex(chAdd)]++;
            if(isCorrect(chkArray, numArray)) answer++;
        }

        System.out.println(answer);
    }

    public static int getIndex(char ch) {
        if(ch == 'A') return 0;
        if(ch == 'C') return 1;
        if(ch == 'G') return 2;
        return 3;
    }

    public static boolean isCorrect(int[] chkArray, int[] numArray) {
        return numArray[0] >= chkArray[0]
            && numArray[1] >= chkArray[1]
            && numArray[2] >= chkArray[2]
            && numArray[3] >= chkArray[3];
    }
}
