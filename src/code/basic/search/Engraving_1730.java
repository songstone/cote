package code.basic.search;

import java.io.IOException;
import java.util.Scanner;

public class Engraving_1730 {
    public static void main_1730(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String move = sc.hasNext() ? sc.next() : "";

        boolean[][] vertical = new boolean[N][N];
        boolean[][] horizontal = new boolean[N][N];

        int curR = 0;
        int curC = 0;

        for (int i = 0; i < move.length(); i++) {
            char command = move.charAt(i);
            if (command == 'D') {
                if(curR == N - 1) continue;
                vertical[curR][curC] = true;
                vertical[curR + 1][curC] = true;
                curR++;
            } else if (command == 'U') {
                if(curR == 0) continue;
                vertical[curR][curC] = true;
                vertical[curR - 1][curC] = true;
                curR--;
            } else if (command == 'L') {
                if(curC == 0) continue;
                horizontal[curR][curC] = true;
                horizontal[curR][curC - 1] = true;
                curC--;
            } else {
                if(curC == N -1) continue;
                horizontal[curR][curC] = true;
                horizontal[curR][curC + 1] = true;
                curC++;
            }
        }

        for (int i = 0; i < N; i++) {
            String ans = "";
            for (int j = 0; j < N; j++) {
                if(vertical[i][j] && horizontal[i][j]) ans += "+";
                else if(vertical[i][j]) ans += "|";
                else if(horizontal[i][j]) ans += "-";
                else ans+= ".";
            }
            System.out.println(ans);
        }

    }

}
