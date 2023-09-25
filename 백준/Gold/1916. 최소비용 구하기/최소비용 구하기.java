import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, M, S ,E;
    static List<Node>[] graph;
    static int[] shortArray;
    static boolean[] visited;

    public static void main(String[] args) {
        input();
        updateShortArray();
        System.out.println(shortArray[E]);
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N + 1];
        shortArray = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            shortArray[i] = Integer.MAX_VALUE;
        }

        while (M-- > 0) {
            graph[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }

        S = sc.nextInt();
        E = sc.nextInt();
        shortArray[S] = 0;
    }

    static void updateShortArray() {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(n -> shortArray[n]));
        queue.add(S);

        while (!queue.isEmpty()) {
            int next = queue.poll();
            if(next == E) break;
            if(visited[next]) continue;
            visited[next] = true;
            for (Node node : graph[next]) {
                shortArray[node.num] = Math.min(node.weight + shortArray[next], shortArray[node.num]);
                queue.add(node.num);
            }
        }
    }

    static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
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