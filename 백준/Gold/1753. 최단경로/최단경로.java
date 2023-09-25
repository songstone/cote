import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int V, E, K;
    static List<Node>[] graph;
    static int[] shortArray;
    static boolean[] visited;

    public static void main(String[] args) {
        input();
        updateShortArray();
        for (int i = 1; i <= V; i++) {
            System.out.println(shortArray[i] != Integer.MAX_VALUE ? shortArray[i] : "INF");
        }
    }

    static void input() {
        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();

        graph = new ArrayList[V + 1];
        shortArray = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            shortArray[i] = Integer.MAX_VALUE;
        }
        shortArray[K] = 0;

        visited = new boolean[V + 1];

        while (E-- > 0) {
            graph[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }
    }

    static void updateShortArray() {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(n -> shortArray[n]));
        queue.add(K);

        while (!queue.isEmpty()) {
            int next = queue.poll();
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