import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, M;
    static int kevinBacon = -1;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        input();
        updateGraph();
        findKevinBacon();
        System.out.println(kevinBacon);
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = 10001;
            }
        }

        while (M-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph[s][e] = 1;
            graph[e][s] = 1;
        }
    }

    static void updateGraph() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }
    }

    static void findKevinBacon() {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if(i == j || graph[i][j] == 10001) continue;
                sum += graph[i][j];
            }
            if(sum != 0 && sum < min) {
                min = sum;
                kevinBacon = i;
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