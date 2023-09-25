import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, K;
    static List<Node>[] graph;
    static PriorityQueue<Integer>[] shortQueueArray;

    public static void main(String[] args) throws IOException {
        input();
        updateShortQueue();
        for (int i = 1; i <= N; i++) {
            PriorityQueue<Integer> shortQueue = shortQueueArray[i];
            if (shortQueue.size() == K) {
                bw.write(shortQueue.peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        graph = new ArrayList[N + 1];
        shortQueueArray = new PriorityQueue[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            shortQueueArray[i] = new PriorityQueue<>(K, (i1, i2) -> i2 - i1);
        }

        while (M-- > 0) {
            graph[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        }
    }

    static void updateShortQueue() {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        queue.offer(new Node(1, 0));
        shortQueueArray[1].add(0);

        while (!queue.isEmpty()) {
            Node nextNode = queue.poll();
            for (Node node : graph[nextNode.num]) {
                PriorityQueue<Integer> pq = shortQueueArray[node.num];
                if(pq.size() < K) {
                    pq.add(nextNode.weight + node.weight);
                    queue.add(new Node(node.num, nextNode.weight + node.weight));
                } else if(pq.peek() > nextNode.weight + node.weight){
                    pq.poll();
                    pq.add(nextNode.weight + node.weight);
                    queue.add(new Node(node.num, nextNode.weight + node.weight));
                }
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