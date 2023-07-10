package code.basic.parametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoneyDraw_6236 {
    public static void main_6236(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] assumeArray = new int[N];
        for (int i = 0; i < N; i++) {
            assumeArray[i] = Integer.parseInt(br.readLine());
        }

        int startAmount = 0;
        int endAmount = N*10000;
        int minValidAmount = -1;

        while (startAmount <= endAmount) {
            int chkAmount = (startAmount + endAmount) / 2;
            if (isPossible(assumeArray, chkAmount, M)) {
                minValidAmount = chkAmount;
                endAmount = chkAmount - 1;
            } else {
                startAmount = chkAmount + 1;
            }
        }
        System.out.println(minValidAmount);
    }

    public static boolean isPossible(int[] assumeArray, int drawAmount, int maxCount) {
        int drawCount = 1;
        int currentAmount = drawAmount;

        for (int assume : assumeArray) {
            if (assume > drawAmount) return false;
            if (currentAmount < assume) {
                if (maxCount == drawCount) return false;
                drawCount++;
                currentAmount = drawAmount;
            }
            currentAmount -= assume;
        }
        return true;
    }
}
