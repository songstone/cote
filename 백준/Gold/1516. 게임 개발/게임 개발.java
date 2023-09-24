import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N;
    static List<Integer>[] graph;
    static boolean[] checked;
    static int[] phaseArray, timeArray, timeSumArray;

    public static void main(String[] args) {
        input();
        phaseCheckTime();
        for (int i = 1; i <= N; i++) {
            System.out.println(timeSumArray[i]);
        }
    }

    static void input() {
        N = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        timeArray = new int[N + 1];
        timeSumArray = new int[N + 1];
        phaseArray = new int[N + 1];
        checked = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            timeArray[i] = sc.nextInt();
            while(true) {
                int chk = sc.nextInt();
                if(chk == -1) break;
                phaseArray[i]++;
                graph[chk].add(i);
            }
        }
    }

    static void phaseCheckTime() {
        int checkCnt = 0;
        while (checkCnt != N) {
            for (int i = 1; i <= N; i++) {
                if(!checked[i] && phaseArray[i] == 0) {
                    checked[i] = true;
                    checkCnt++;
                    timeSumArray[i] += timeArray[i];
                    for (int j : graph[i]) {
                        timeSumArray[j] = Math.max(timeSumArray[i], timeSumArray[j]);
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