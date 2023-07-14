package code.basic.twoPointer;

import java.io.IOException;
import java.util.Scanner;

public class JunpyoStone_15831 {
    public static void main_15831(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();

        char[] stones = sc.next().toCharArray();

        int blackCnt = 0;
        int whiteCnt = 0;
        int chkIndex = 0;
        int maxLength = 0;
        for (int startIndex = 0; startIndex < N; startIndex++) {

            while(chkIndex < N) {
                if(stones[chkIndex] == 'B' && blackCnt == B) break;
                if(stones[chkIndex++] == 'B') blackCnt++;
                else whiteCnt++;
            }
            if(whiteCnt >= W) maxLength = Math.max(maxLength, chkIndex - startIndex);

            if(stones[startIndex] == 'B') blackCnt--;
            else whiteCnt--;
        }

        System.out.println(maxLength);
    }
}
