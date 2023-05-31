package code.basic.search;

import java.util.Scanner;

public class String_1120 {
    public static void main_1120(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        char[] target = sc.next().toCharArray();

        int minCount = target.length;

        for (int i = 0; i <= target.length - input.length ; i++) {
            int count = 0;
            for (int j = 0; j < input.length; j++) {
                if(input[j] != target[i+j]) count++;
            }
            minCount = Math.min(count, minCount);
        }

        System.out.println(minCount);
    }
}
