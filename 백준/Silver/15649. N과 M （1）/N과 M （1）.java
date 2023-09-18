import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] selected;
    static boolean[] used;
    static int N;
    static int M;

    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(sb);
    }

    static void input() {
        CustomScanner sc = new CustomScanner();
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M + 1];
        used = new boolean[N + 1];
        sb = new StringBuffer();
    }

    static void rec_func(int k) {
        if(k > M) {
            for (int i = 1; i < selected.length; i++) {
                sb.append(selected[i]);
                sb.append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if(!used[i]) {
                    selected[k] = i;
                    used[i] = true;
                    rec_func(k + 1);
                    used[i] = false;
                }
            }
        }
    }

    static class CustomScanner {
        private BufferedReader br;
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