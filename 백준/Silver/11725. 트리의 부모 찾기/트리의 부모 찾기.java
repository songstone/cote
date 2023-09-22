import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static CustomScanner sc = new CustomScanner();
    static int N;
    static List<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    static void input() {
        N = sc.nextInt();
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int src = sc.nextInt();
            int des = sc.nextInt();
            graph[src].add(des);
            graph[des].add(src);
        }
    }

    static void DFS(int k) {
        visited[k] = true;
        for (Integer i : graph[k]) {
            if(!visited[i]) {
                parent[i] = k;
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