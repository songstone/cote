import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, S;
    static long answer;
    static int[] nums;
    static HashMap<Integer, Integer> sumMap;

    public static void main(String[] args) throws IOException {
        input();
        left_rec_func(0, N/2 ,0);
        right_rec_func(N/2, N, 0);
        if(S == 0) answer--;
        System.out.println(answer);
    }

    static void input() {
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        sumMap = new HashMap<>();
    }

    static void left_rec_func(int k, int end, int value) {
        if(k == end) {
            sumMap.put(value, sumMap.getOrDefault(value, 0) + 1);
        } else {
            left_rec_func(k+1, end,value + nums[k]);
            left_rec_func(k+1, end, value);
        }
    }

    static void right_rec_func(int k, int end, int value) {
        if (k == end) {
            answer += sumMap.getOrDefault(S - value, 0);
        } else {
            right_rec_func(k+1, end, value + nums[k]);
            right_rec_func(k+1, end, value);
        }
    }

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