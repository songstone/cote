import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] times = new int[N];

        for (int i = 0; i < N; i++) {
            times[i] = sc.nextInt();
        }

        long chkLeftTime = 1;
        long chkRightTime = (long) Arrays.stream(times).min().getAsInt() * M;

        long answer = chkRightTime;

        while (chkLeftTime <= chkRightTime) {
            long chkTime = (chkLeftTime + chkRightTime) / 2;
            if (enablePassCnt(chkTime, times) >= M) {
                answer = chkTime;
                chkRightTime = chkTime - 1;
            } else {
                chkLeftTime = chkTime + 1;
            }
        }
        System.out.println(answer);
    }

    public static long enablePassCnt(long chkTime, int[] times) {
        long count = 0;
        for (int time : times) {
            count += chkTime / time;
        }
        return count;
    }
}

