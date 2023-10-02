import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N;
    static long[][] D;

    public static void main(String[] args) {
        input();
        initDynamicArray();
        System.out.println(D[0][N] + D[1][N]);
    }

    static void input() {
        N = sc.nextInt();
        D = new long[2][N + 1];
        D[0][1] = 0;
        D[1][1] = 1;
    }

    static void initDynamicArray() {
        for (int i = 2; i <= N; i++) {
            D[0][i] = D[0][i - 1] + D[1][i - 1];
            D[1][i] = D[0][i - 1];
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