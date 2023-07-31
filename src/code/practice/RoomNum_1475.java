package code.practice;

import java.io.IOException;
import java.util.Scanner;

public class RoomNum_1475 {
    public static void main_1475(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        int[] numCount = new int[10];
        char[] inputNum = sc.next().toCharArray();

        for (int i = 0; i < inputNum.length; i++) {
            numCount[inputNum[i] - '0']++;
        }

        int maxCount = 0;
        for (int i = 0; i < numCount.length - 1; i++) {
            int count = numCount[i];
            if(i == 6) {
                count = ((numCount[i] + numCount[9]) + 1) / 2;
            }
            if(count > maxCount) maxCount = count;
        }

        System.out.println(maxCount);
    }
}
