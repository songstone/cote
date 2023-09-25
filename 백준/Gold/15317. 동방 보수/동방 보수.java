import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMX = br.readLine().split(" ");
        int N = Integer.parseInt(NMX[0]);
        int M = Integer.parseInt(NMX[1]);
        int X = Integer.parseInt(NMX[2]);

        int[] roomMoney = new int[N];
        int[] clubMoney = new int[M];

        String[] roomInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            roomMoney[i] = Integer.parseInt(roomInput[i]);
        }

        String[] clubInput = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            clubMoney[i] = Integer.parseInt(clubInput[i]);
        }

        Arrays.sort(roomMoney);
        Arrays.sort(clubMoney);

        int leftCnt = 0;
        int rightCnt = Math.min(M, N);
        int maxEnableCnt = 0;
        while(leftCnt <= rightCnt) {
            int chkCnt = (leftCnt + rightCnt) / 2;
            if(needMoney(roomMoney, clubMoney, chkCnt) <= X) {
                maxEnableCnt = chkCnt;
                leftCnt = chkCnt + 1;
            } else {
                rightCnt = chkCnt - 1;
            }
        }

        System.out.println(maxEnableCnt);
    }

    public static long needMoney(int[] roomMoney, int[] clubMoney, int trialCnt) {
        long money = 0;
        for (int i = 0; i < trialCnt; i++) {
            money += Math.max(roomMoney[i] - clubMoney[clubMoney.length - trialCnt + i], 0);
        }
        return money;
    }
}

