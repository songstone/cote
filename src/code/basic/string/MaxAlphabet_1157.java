package code.basic.string;

import java.util.Scanner;

public class MaxAlphabet_1157 {
    public static void main_1157(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int[] count = getUpperAlphabetCount(input);

        int max = 0;
        char maxAlphabet = '?';

        for (int i = 0; i < count.length; i++) {
            if(count[i] > max) {
                max = count[i];
                maxAlphabet = (char) (i + 'A');
            } else if(count[i] == max) {
                maxAlphabet = '?';
            }
        }
        System.out.println(maxAlphabet);
    }

    public static int[] getUpperAlphabetCount(String str) {
        str = str.toUpperCase();
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'A']++;
        }
        return count;
    }
}
