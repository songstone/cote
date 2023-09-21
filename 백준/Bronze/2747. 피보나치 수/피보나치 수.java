import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] cache = new int[46];
    static CustomScanner sc = new CustomScanner();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(rec_func(N));
    }

    static void input() {
        N = sc.nextInt();
    }

    static int rec_func(int k) {
        if(k == 1 || k == 2) return 1;
        if(cache[k] != 0) return cache[k];
        else {
            cache[k] = rec_func(k - 1) + rec_func(k - 2);
            return cache[k];
        }
    }

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