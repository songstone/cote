import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int T;
    static int[][] D;

    public static void main(String[] args) {
        input();
        while(T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(D[M][N]);
        }
    }

    static void input() {
        T = sc.nextInt();
        D = new int[31][31];
        for (int i = 0; i < 31; i++) {
            D[i][0] = 1;
            D[i][i] = 1;
            D[i][1] = i;
        }

        for (int i = 2; i < 31; i++) {
            for (int j = 1; j < 31; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
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