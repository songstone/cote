import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N;
    static int[] T, P, D;

    public static void main(String[] args) {
        input();
        initDynamicArray();
        System.out.println(D[1]);
    }

    static void input() {
        N = sc.nextInt();
        T = new int[N + 1];
        P = new int[N + 1];
        D = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
    }

    static void initDynamicArray() {
        for (int i = N; i > 0; i--) {
            if(T[i] + i > N + 1){
                D[i] = D[i + 1];
            } else {
                D[i] = Math.max(D[i + 1], D[i + T[i]] + P[i]);
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