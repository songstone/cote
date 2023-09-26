import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        input();
        updateGraph();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 100001) System.out.print(0 + " ");
                else System.out.print(1 + " ");
            }
            System.out.println();
        }
    }

    static void input() {
        N = sc.nextInt();

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int v = sc.nextInt();
                graph[i][j] = v == 0 ? 100001 : v;
            }
        }
    }

    static void updateGraph() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
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