package code.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateSushi_15961 {
    public static void main_15961(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] Ndkc = br.readLine().split(" ");
        int N = Integer.parseInt(Ndkc[0]);
        int d = Integer.parseInt(Ndkc[1]);
        int k = Integer.parseInt(Ndkc[2]);
        int c = Integer.parseInt(Ndkc[3]);

        int[] dishes = new int[N];
        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        int[] sushiNumArr = new int[d+1];
        int startIndex = 0;
        int sushiTypeCnt = 0;
        for (int i = 0; i < k; i++) {
            sushiNumArr[dishes[i]]++;
        }
        for (int i = 1; i < sushiNumArr.length; i++) {
            if(sushiNumArr[i] !=0) sushiTypeCnt++;
        }
        int maxSushiTypeCnt = sushiNumArr[c] == 0 ? sushiTypeCnt + 1 : sushiTypeCnt;

        while(startIndex < N - 1) {
            int endIndex = startIndex + k;
            if(endIndex >= N) endIndex = endIndex % N;

            sushiNumArr[dishes[startIndex]]--;
            if(sushiNumArr[dishes[startIndex]] == 0) sushiTypeCnt--;
            sushiNumArr[dishes[endIndex]]++;
            if(sushiNumArr[dishes[endIndex]] == 1) sushiTypeCnt++;

            int chkSushiTypeCnt = sushiNumArr[c] == 0 ? sushiTypeCnt + 1 : sushiTypeCnt;
            if(chkSushiTypeCnt > maxSushiTypeCnt) {
                maxSushiTypeCnt = chkSushiTypeCnt;
            }
            startIndex++;
        }

        System.out.println(maxSushiTypeCnt);
    }
}
