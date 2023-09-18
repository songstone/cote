import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums, operators, order;
    static int N;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        rec_func(0, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void input() {
        CustomScanner sc = new CustomScanner();
        N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }
        order = new int[N-1];
    }

    static void rec_func(int k, int value) {
        if(k == N-1) {
            if(value > max) max = value;
            if(value < min) min = value;
        } else {
            for (int i = 0; i < operators.length; i++) {
                if(operators[i] == 0) continue;
                order[k] = i;
                operators[i]--;

                int calc_value = value;

                if(i == 0) calc_value += nums[k + 1];
                else if(i == 1) calc_value -= nums[k + 1];
                else if(i == 2) calc_value *= nums[k + 1];
                else calc_value /= nums[k + 1];

                rec_func(k+1, calc_value);
                operators[i]++;
            }
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