package code.basic.string;

import java.util.Scanner;

public class Anagram_1919 {
    public static void main_1919(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] countA = getAlphabetCount(a);
        int[] countB = getAlphabetCount(b);

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer +=  Math.abs(countA[i] - countB[i]);
        }
        System.out.println(answer);
    }

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
}
