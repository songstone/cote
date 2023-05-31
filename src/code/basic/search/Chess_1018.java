package code.basic.search;

import java.util.Scanner;

public class Chess_1018 {
    public static boolean[][] board;
    public static int min = 64;

    public static void main_1018(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String string = sc.next();
            for (int j = 0; j < M; j++) {
                if (string.charAt(j) == 'W') {
                    board[i][j] = true;		// W일 때는 true
                } else {
                    board[i][j] = false;		// B일 때는 false
                }
            }
        }

        int row = N - 7;
        int col = M - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                check(i, j);
            }
        }
        System.out.println(min);
    }


    public static void check(int startX, int startY) {
        int endX = startX + 8;
        int endY = startY + 8;
        int count = 0;

        boolean chkColor = board[startX][startY];	// 첫 번째 칸의 색

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (board[i][j] != chkColor) {
                    count++;
                }
                chkColor = (!chkColor);
            }
            chkColor = !chkColor;
        }
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
