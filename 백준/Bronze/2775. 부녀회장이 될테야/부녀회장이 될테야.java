import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int T;
    static int[][] D;

    public static void main(String[] args) {
        input();
        while(T-- > 0) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            System.out.println(D[K][N]);
        }
    }

    static void input() {
        T = sc.nextInt();

        D = new int[15][15];
        for (int i = 0; i <= 14; i++) {
            D[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j];
            }
        }
    }



    // --------------------------------------
    static class CustomScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        public CustomScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}