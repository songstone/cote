import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, M;
    static int[] array;

    public static void main(String[] args) throws IOException {
        input();
        int prevIndex = find(sc.nextInt());
        boolean enable = true;
        for (int i = 1; i < M; i++) {
            int findIndex = find(sc.nextInt());
            if(prevIndex != findIndex) {
                enable = false;
                break;
            }
        }
        if(enable) System.out.println("YES");
        else System.out.println("NO");
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        array = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (sc.nextInt() == 1) union(i, j);
            }
        }
    }

    static void union(int a, int b) {
        int aRepIndex = find(a);
        int bRepIndex = find(b);

        array[bRepIndex] = array[aRepIndex];
    }

    static int find(int a) {
        if (array[a] == a) return a;
        int nextIndex = find(array[array[a]]);
        array[a] = nextIndex;
        return nextIndex;
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