import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N;
    static long[][] D;

    public static void main(String[] args) {
        input();
        initDynamicArray();

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + D[N][i]) % 1000000000;
        }
        System.out.println(sum);
    }

    static void input() {
        N = sc.nextInt();
        D = new long[N + 1][10];
        for (int i = 1; i <= 9; i++) {
            D[1][i] = 1;
        }
    }

    static void initDynamicArray() {
        for (int i = 2; i <= N; i++) {
            D[i][9] = D[i - 1][8];
            D[i][0] = D[i - 1][1];
            for (int j = 1; j <= 8 ; j++) {
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % 1000000000;
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