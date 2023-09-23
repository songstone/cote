import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] trust;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            DFS(i);
        }

        int max = Arrays.stream(trust).max().getAsInt();
        for (int i = 1; i <= N ; i++) {
            if(trust[i] == max) System.out.print(i + " ");
        }
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        trust = new int[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            graph[sc.nextInt()].add(sc.nextInt());
        }
    }

    static void DFS(int num) {
        visited[num] = true;
        for (int i : graph[num]) {
            if(!visited[i]) {
                trust[i] += 1;
                DFS(i);
            }
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