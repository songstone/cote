import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static CustomScanner sc = new CustomScanner();
    static StringBuilder sb = new StringBuilder();

    static int L, C;
    static char[] chars;
    static boolean[] used;

    static char[] chk = {'a', 'e', 'i', 'o', 'u'};
    static char[] candidate;

    public static void main(String[] args) throws IOException {
        input();
        rec_func(0, 0);
        System.out.println(sb);
    }

    static void input() {
        L = sc.nextInt();
        C = sc.nextInt();
        chars = sc.nextLine().replace(" ",  "").toCharArray();
        Arrays.sort(chars);
        used = new boolean[C];
        candidate = new char[L];
    }

    static void rec_func(int k, int startIndex) {
        if (k == L) {
            String candidateStr = String.valueOf(candidate);
            if (enable(candidateStr)) {
                sb.append(candidate);
                sb.append("\n");
            }
        } else {
            for (int i = startIndex; i < C; i++) {
                if(!used[i]) {
                    used[i] = true;
                    candidate[k] = chars[i];
                    rec_func(k + 1, i);
                    used[i] = false;
                }
            }
        }
    }

    static boolean enable(String candidate) {
        int gatherCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (candidate.indexOf(chk[i]) != -1) gatherCnt++;
        }
        return gatherCnt >= 1 && candidate.length() - gatherCnt >= 2;
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