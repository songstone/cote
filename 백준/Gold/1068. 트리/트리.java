import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, parentNode, deleteNode, leafCnt;
    static List<Integer>[] graph;

    public static void main(String[] args) {
        input();
        findLeaf(parentNode);
        System.out.println(leafCnt);
    }

    static void input() {
        N = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int parentNodeNum = sc.nextInt();
            if(parentNodeNum == -1) parentNode = i;
            else graph[parentNodeNum].add(i);
        }

        deleteNode = sc.nextInt();
    }

    static void findLeaf(int node) {
        if(node == deleteNode) return;
        int childNode = 0;
        for (int nextNode : graph[node]) {
            if (nextNode != deleteNode) {
                childNode++;
                findLeaf(nextNode);
            }
        }
        if(childNode == 0) leafCnt++;
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