import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, M, K;
    static int adjNum;
    static long[] tree;

    public static void main(String[] args) {
        input();
        for (int i = 0; i < M + K; i++) {
            int flag = sc.nextInt();
            if(flag == 1) update(sc.nextInt(), sc.nextLong());
            else output(sc.nextInt(), sc.nextInt());
        }
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        int chk = 0;
        while(1 << chk < N){
            chk++;
        }
        adjNum = ((int) Math.pow(2, chk));
        tree = new long[adjNum * 2];

        for (int i = 0; i < N; i++) {
            tree[adjNum + i] = sc.nextLong();
        }

        for (int i = adjNum-1; i > 0 ; i--) {
            tree[i] = tree[i*2] + tree[i*2 + 1];
        }
    }

    static void update(int index, long value) {
        int targetIndex = adjNum + index - 1;
        long tempValue = tree[targetIndex];
        tree[targetIndex] = value;

        long sub = value - tempValue;
        while(targetIndex >= 2) {
            targetIndex /= 2;
            tree[targetIndex] += sub;
        }
    }

    static void output(int startIndex, int endIndex) {
        long sum = 0;
        startIndex = adjNum + startIndex -1;
        endIndex = adjNum + endIndex - 1;
        while(startIndex <= endIndex) {
            if(startIndex % 2 == 1) sum += tree[startIndex];
            if(endIndex % 2 == 0) sum += tree[endIndex];
            startIndex = (startIndex + 1) /2;
            endIndex = (endIndex - 1) /2;
        }
        System.out.println(sum);
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