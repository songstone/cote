import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, M;
    static int adjNum;
    static int[] tree;

    public static void main(String[] args) {
        input();
        while (M-- > 0) {
            output(sc.nextInt(), sc.nextInt());
        }
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        int chk = 0;
        while (1 << chk < N) {
            chk++;
        }
        adjNum = (int) Math.pow(2, chk);

        tree = new int[adjNum * 2];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            tree[adjNum + i] = sc.nextInt();
        }

        for (int i = adjNum-1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
    }

    static void output(int startIndex, int endIndex) {
        startIndex = startIndex + adjNum -1;
        endIndex = endIndex + adjNum - 1;

        int min = Integer.MAX_VALUE;
        while (startIndex <= endIndex) {
            if(startIndex % 2 == 1) min = Math.min(min, tree[startIndex++]);
            if(startIndex % 2 == 0) min = Math.min(min, tree[endIndex--]);
            startIndex = startIndex / 2;
            endIndex = endIndex / 2;
        }
        System.out.println(min);
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