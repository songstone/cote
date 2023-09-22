import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();
    static int N, M, K, X;
    static List<Integer>[] graph;
    static int[] distance;


    public static void main(String[] args) throws IOException {
        input();
        BFS(X);
        boolean find = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                find = true;
                System.out.println(i);
            }
        }
        if (!find) System.out.println(-1);
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        distance = new int[N + 1];
        for (int i = 0; i <= N ; i++) {
            distance[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            graph[sc.nextInt()].add(sc.nextInt());
        }
    }

    public static void BFS(int cityNum) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cityNum);
        distance[cityNum]++;
        while (!queue.isEmpty()) {
            int chkCityNum = queue.poll();
            for (int nextCity : graph[chkCityNum]) {
                int prevDistance = distance[chkCityNum];
                if (prevDistance == K) return;
                if (distance[nextCity] == -1) {
                    distance[nextCity] = prevDistance + 1;
                    queue.add(nextCity);
                }
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