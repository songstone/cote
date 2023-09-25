import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, M;
    static long[] shortArray;
    static List<Edge> edgeList;

    static boolean minusCycle = false;

    public static void main(String[] args) throws IOException {
        input();
        updateShortArray(N - 1);
        checkMinusCycle();
        if(minusCycle) System.out.println(-1);
        else {
            for (int i = 2; i <= N ; i++) {
                if(shortArray[i] == Integer.MAX_VALUE) System.out.println(-1);
                else System.out.println(shortArray[i]);
            }
        }
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        edgeList = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            edgeList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        shortArray = new long[N + 1];
        shortArray[1] = 0;
        for (int i = 2; i <= N; i++) {
            shortArray[i] = Integer.MAX_VALUE;
        }
    }

    static void updateShortArray(int k) {
        for (int i = 0; i < k; i++) {
            for (Edge edge : edgeList) {
                if(shortArray[edge.start] != Integer.MAX_VALUE && shortArray[edge.end] > shortArray[edge.start] + edge.weight) {
                    shortArray[edge.end] = shortArray[edge.start] + edge.weight;
                }
            }
        }
    }

    static void checkMinusCycle() {
        long[] snapshot = Arrays.copyOf(shortArray, shortArray.length);
        updateShortArray(1);
        for (int i = 1; i <= N; i++) {
            if(snapshot[i] != shortArray[i]) {
                minusCycle = true;
                return;
            }
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
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