import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long digit = getGcdDigit(A, B);

        StringBuilder sb = new StringBuilder();
        while (digit-- > 0) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    public static long getGcdDigit(long A, long B) {
        long small = Math.min(A, B);
        long big = Math.max(A, B);
        long remain = big % small;
        if(remain == 0) return small;
        else {
            return getGcdDigit(remain, small);
        }
    }

}
