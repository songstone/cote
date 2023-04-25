package code.basic.string;

import java.util.Scanner;

public class DocSearch_1543 {
    public static void main_1543(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String searchWord = sc.nextLine();

        int count = 0;
        int searchWordLength = searchWord.length();
        int startIndex = 0;

        while(input.length() >= searchWordLength) {
            int index = input.indexOf(searchWord, startIndex);
            if(index == -1) break;
            count++;
            startIndex = index + searchWordLength;
        }
        System.out.println(count);
    }
}
