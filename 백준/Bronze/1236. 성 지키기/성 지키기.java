import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] guardMap = new char[N][M];
        for (int i = 0; i < N; i++) {
            guardMap[i] = sc.next().toCharArray();
        }

        boolean[] existRowArray = new boolean[N];
        boolean[] existColArray = new boolean[M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (guardMap[r][c] == 'X') {
                    existRowArray[r] = true;
                    existColArray[c] = true;
                }
            }
        }

        int needRowCount = N;
        for (int i = 0; i < existRowArray.length; i++) {
            if(existRowArray[i]) needRowCount--;
        }

        int needColCount = M;
        for (int i = 0; i < existColArray.length; i++) {
            if(existColArray[i]) needColCount--;
        }

        System.out.println(Math.max(needRowCount, needColCount));
    }
}
