import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        boolean[] isDeleted = new boolean[end + 1];

        deleteNonPrimeNumber(isDeleted);

        for (int i = start; i < isDeleted.length; i++) {
            if(!isDeleted[i]) System.out.println(i);
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
}
