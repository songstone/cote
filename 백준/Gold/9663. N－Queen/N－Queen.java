import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] cols;
    static int N, answer;

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(answer);
    }

    static void input() {
        CustomScanner sc = new CustomScanner();
        N = sc.nextInt();
        cols = new int[N + 1];
    }

    static void rec_func(int k) {
        if(k > N) {
            answer++;
        } else {
            for (int i = 1; i <= N; i++) {
                boolean isPossible = true;
                for (int j = 1; j < k; j++) {
                    if(attackable(k, i, j, cols[j])) {
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible) {
                    cols[k] = i;
                    rec_func(k+1);
                    cols[k] = 0;
                }
            }
        }
    }

    static boolean attackable(int row1, int col1, int row2, int col2) {
        if(col1 == col2) return true;
        if(row1 - col1 == row2 - col2) return true;
        if(row1 + col1 == row2 + col2) return true;
        return false;
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