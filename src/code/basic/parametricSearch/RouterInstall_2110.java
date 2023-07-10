package code.basic.parametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RouterInstall_2110 {
    public static void main_2110(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] houseArray = new int[N];
        for (int i = 0; i < N; i++) {
            houseArray[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houseArray);

        int startDistance = 1;
        int endDistance = houseArray[N-1] - houseArray[0];
        int answer = -1;

        while (startDistance <= endDistance) {
            int chkDistance = (startDistance + endDistance) / 2;
            if(possibleCnt(houseArray, chkDistance) >= M) {
                answer = chkDistance;
                startDistance = chkDistance + 1;
            } else {
                endDistance = chkDistance - 1;
            }
        }

        System.out.println(answer);
    }

    public static int possibleCnt(int[] houseArray, int distance) {
        int pastHouse = houseArray[0];
        int cnt = 1;

        for (int i = 1 ; i < houseArray.length; i++) {
            if(houseArray[i] - pastHouse >= distance) {
                pastHouse = houseArray[i];
                cnt++;
            }
        }
        return cnt;
    }
}
