package code.basic.search;

import java.io.IOException;
import java.util.Scanner;

public class CandyGame_3058 {
    public static void main_3058(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swap(map, i, j, i, j+1);
                    answer = Math.max(answer, Math.max(maxColumnCnt(map), maxRowCnt(map)));
                    swap(map, i, j, i, j+1);
                }
                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    swap(map, i, j, i+1, j);
                    answer = Math.max(answer, Math.max(maxColumnCnt(map), maxRowCnt(map)));
                    swap(map, i, j, i+1, j);
                }
            }
        }
        System.out.println(answer);
    }

    public static void swap(char[][] map, int x1, int y1, int x2, int y2) {
        char tmp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = tmp;
    }

    public static int maxRowCnt(char[][] map) {
        int N = map.length;
        int maxRow = 0;
        for (int i = 0; i < N; i++) {
            int rowLength = 1;
            for (int j = 1; j < N; j++) {
                if (map[i][j] == map[i][j-1]) rowLength++;
                else {
                    maxRow = Math.max(maxRow, rowLength);
                    rowLength = 1;
                }
            }
            maxRow = Math.max(maxRow, rowLength);
        }
        return maxRow;
    }

    public static int maxColumnCnt(char[][] map) {
        int N = map.length;
        int maxColumn = 0;
        for (int j = 0; j < N; j++) {
            int columnLength = 1;
            for (int i = 1; i < N; i++) {
                if (map[i][j] == map[i-1][j]) columnLength++;
                else {
                    maxColumn = Math.max(maxColumn, columnLength);
                    columnLength = 1;
                }
            }
            maxColumn = Math.max(maxColumn, columnLength);
        }
        return maxColumn;
    }
}
