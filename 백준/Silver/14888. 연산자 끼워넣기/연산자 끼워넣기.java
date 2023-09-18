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
        rec_func(0);
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

    static int calculate() {
        int answer = nums[0];
        for (int i = 0; i < order.length; i++) {
            int operator = order[i];

            if(operator == 0) answer += nums[i + 1];
            else if(operator == 1) answer -= nums[i + 1];
            else if(operator == 2) answer *= nums[i + 1];
            else answer /= nums[i + 1];
        }
        return answer;
    }

    static void rec_func(int k) {
        if(k > N-2) {
            int answer = calculate();
            if(answer > max) max = answer;
            if(answer < min) min = answer;
        } else {
            for (int i = 0; i < operators.length; i++) {
                if(operators[i] == 0) continue;
                order[k] = i;
                operators[i]--;
                rec_func(k+1);
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