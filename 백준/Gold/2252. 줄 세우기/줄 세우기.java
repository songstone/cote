import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, M;
    static List<Integer>[] graph;
    static List<Integer> sortList;
    static boolean[] sorted;
    static int[] phaseArray;

    public static void main(String[] args) {
        input();
        phaseSort();
        for (int num : sortList) {
            System.out.print(num + " ");
        }
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        sortList = new ArrayList<>(N);
        sorted = new boolean[N + 1];
        phaseArray = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            phaseArray[end]++;
            graph[start].add(end);
        }
    }

    static void phaseSort() {
        int sortNumber = 0;
        while (sortNumber != N) {
            for (int i = 1; i <= N; i++) {
                if(!sorted[i] && phaseArray[i] == 0) {
                    sortList.add(i);
                    sorted[i] = true;
                    sortNumber++;
                    for (int j : graph[i]) {
                        phaseArray[j]--;
                    }
                }
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