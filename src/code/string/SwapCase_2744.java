package code.string;

import java.util.Scanner;

public class SwapCase_2744 {
    public static void main_2744(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();

        char[] charArray = inputString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] <= 'Z' && charArray[i] >= 'A') {
                charArray[i] = (char) ('a' + charArray[i] - 'A');
            } else charArray[i] = (char) ('A' + charArray[i] - 'a');
        }

        System.out.println(charArray);
    }
}
