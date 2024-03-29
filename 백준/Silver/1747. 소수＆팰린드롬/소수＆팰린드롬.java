import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        boolean[] isDeleted = new boolean[10000001];

        deleteNonPrimeNumber(isDeleted);

        for (int i = num; i < isDeleted.length; i++) {
            if(!isDeleted[i]) {
                if(isPalindrome(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static void deleteNonPrimeNumber(boolean[] isDeleted) {
        isDeleted[1] = true;
        for (int i = 2; i <= Math.sqrt(isDeleted.length-1); i++) {
            if(!isDeleted[i]) {
                for (int j = 2*i; j <= isDeleted.length-1; j += i) {
                    isDeleted[j] = true;
                }
            }
        }
    }

    public static boolean isPalindrome(int num) {
        char[] numArray = String.valueOf(num).toCharArray();
        for (int i = 0; i < numArray.length / 2; i++) {
            char A = numArray[i];
            char B = numArray[numArray.length-1 - i];
            if(A != B) return false;
        }
        return true;
    }
}
