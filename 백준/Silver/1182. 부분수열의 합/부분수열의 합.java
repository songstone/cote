import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, answer;
    static int[] nums;

    static CustomScanner sc = new CustomScanner();

    public static void main(String[] args) throws IOException {
        input();
        rec_function(1, 0);
        if(S == 0) answer--;
        System.out.println(answer);
    }

    static void input() {
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N+1];

        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void rec_function(int k, int value) {
        if(k == N + 1) {
            if(value == S) answer++;
        } else {
            rec_function(k + 1, value + nums[k]);
            rec_function(k + 1, value);
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