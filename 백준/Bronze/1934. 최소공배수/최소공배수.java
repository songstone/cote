import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int gcd = getGcd(A, B);
            System.out.println(A*B / gcd);
        }
    }

    public static int getGcd(int A, int B) {
        int small = Math.min(A, B);
        int big = Math.max(A, B);

        int remain = big % small;
        if(remain == 0 || small == 1) return small;
        else return getGcd(small, remain);
    }

}
