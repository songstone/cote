import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N;
    static int[] D;

    public static void main(String[] args) {
        input();
        initDynamicArray();
        System.out.println(D[N]);
    }

    static void input() {
        N = sc.nextInt();
        D = new int[N + 1];

        D[1] = 0;
    }

    static void initDynamicArray() {
        for (int i = 2; i <= N; i++) {
            D[i] = D[i-1] + 1;
            if(i % 2 == 0) D[i] = Math.min(D[i], D[i / 2] + 1);
            if(i % 3 == 0) D[i] = Math.min(D[i], D[i / 3] + 1);
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