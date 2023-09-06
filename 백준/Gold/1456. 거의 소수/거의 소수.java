import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long start = sc.nextLong();
        long end = sc.nextLong();

        boolean[] isDeleted = new boolean[((int) Math.sqrt(end)) + 1];

        deleteNonPrimeNumber(isDeleted);

        int answer = 0;
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if(!isDeleted[i]) {
                long chkNum = (long)i * i;
                while(chkNum <= end) {
                    if(chkNum >= start) answer++;

                    if(chkNum > Long.MAX_VALUE/i) break;
                    else chkNum *= i;
                }
            }
        }
        System.out.println(answer);
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
