import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static CustomScanner sc = new CustomScanner();
    static int N, T;
    static List<Integer>[] graph;
    static int[] sum;
    static int[] inputSum;


    public static void main(String[] args) throws IOException {
        input();
        while (T-- > 0) {
            inputSum[sc.nextInt()] += sc.nextInt();
        }

        for (int i = 2; i <= N; i++) {
            if(inputSum[i] > 0) praise(i, inputSum[i]);
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(sum[i]);
        }
    }

    static void input() {
        N = sc.nextInt();
        T = sc.nextInt();
        graph = new ArrayList[N + 1];
        sum = new int[N + 1];
        inputSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        sc.nextInt();
        for (int i = 2; i <= N; i++) {
            graph[sc.nextInt()].add(i);
        }
    }

    static void praise(int num, int weight) {
        sum[num] += weight;
        for (int i : graph[num]) {
            praise(i, weight);
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