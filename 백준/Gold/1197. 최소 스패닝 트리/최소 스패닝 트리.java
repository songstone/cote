import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, M;
    static int answer = 0;

    static List<Edge> edgeList = new ArrayList<>();
    static int[] unionArray;

    public static void main(String[] args) {
        input();
        edgeList.sort(Comparator.comparingInt(edge -> edge.weight));
        findAnswer();
        System.out.println(answer);
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        unionArray = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            unionArray[i] = i;
        }

        for (int i = 0; i < M; i++) {
            edgeList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
    }

    static void findAnswer() {
        int unionCnt = 0;
        while(unionCnt < N - 1) {
            for (Edge edge : edgeList) {
                if(union(edge.start, edge.end)) {
                    unionCnt++;
                    answer += edge.weight;
                }
            }
        }
    }

    static boolean union(int a, int b) {
        int aRepIndex = find(a);
        int bRepIndex = find(b);

        if(aRepIndex != bRepIndex) {
            unionArray[bRepIndex] = unionArray[aRepIndex];
            return true;
        }
        return false;
    }

    static int find(int a) {
        if(a == unionArray[a]) {
            return a;
        } else {
            return unionArray[a] = find(unionArray[a]);
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