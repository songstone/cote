import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] times = new int[N];

        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int time = sc.nextInt();
            times[i] = time;
            if (time < minTime) minTime = time;
        }

        long totalMaxTime = (long)minTime * M;

        long chkLeftTime = 1;
        long chkRightTime = totalMaxTime;

        long answer = totalMaxTime;

        while(chkLeftTime <= chkRightTime) {
            long chkTime = (chkLeftTime + chkRightTime) / 2;
            if(enablePassCnt(chkTime, times) >= M) {
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
            count += chkTime/time;
        }
        return count;
    }
}

