import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] isDeleted = new boolean[((int)(max - min)) + 1];
        for (long i = 2; i * i <= max; i++) {
            long chkNum = i * i;
            long start = min / chkNum ;
            if(min % chkNum != 0) start++;

            for (long j = start; (j * chkNum) <= max; j++) {
                isDeleted[(int) (j * chkNum - min)] = true;
            }
        }

        int answer = 0;
        for (boolean delete : isDeleted) {
            if (!delete) answer++;
        }
        System.out.println(answer);
    }

}