package code.basic.search;

import java.util.Scanner;

public class NumberMethod_2745 {
    public static void main_2745(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] numArray = sc.next().toCharArray();
        int B = sc.nextInt();

        long result = 0;

        for (int i = 0; i < numArray.length; i++) {
            int k = numArray[i] - 'A' < 0 ? numArray[i] - '0' : numArray[i] - 'A' + 10;
            result += k * Math.pow(B, numArray.length - 1 - i);
        }

        System.out.println(result);
    }
}
