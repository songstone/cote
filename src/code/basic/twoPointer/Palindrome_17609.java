package code.basic.twoPointer;

import java.io.IOException;
import java.util.Scanner;

public class Palindrome_17609 {
    public static void main_17609(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        while(N-- > 0) {
            char[] inputString = sc.next().toCharArray();
            int startIndex = 0;
            int endIndex = inputString.length - 1;
            int result = 0;

            while(startIndex < endIndex) {
                if(inputString[startIndex] == inputString[endIndex]) {
                    startIndex++;
                    endIndex--;
                } else {
                    result++;
                    if(!isPalindrome(inputString, startIndex + 1, endIndex) && !isPalindrome(inputString, startIndex, endIndex -1 )) result++;
                    break;
                }
            }

            System.out.println(result);
        }
    }

    public static boolean isPalindrome(char[] str, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            if(str[startIndex] == str[endIndex]) {
                startIndex++;
                endIndex--;
            } else return false;
        }
        return true;
    }
}
