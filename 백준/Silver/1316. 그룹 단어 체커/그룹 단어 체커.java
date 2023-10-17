import java.io.*;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();
    static int N, answer;
    static boolean[] used;


    public static void main(String[] args) {
        input();
        while(N-- > 0) {
            checkWord(sc.next());
        }

        System.out.println(answer);
    }

    public static void checkWord(String word) {
        used = new boolean[26];
        used[word.charAt(0) - 'a'] = true;
        for (int i = 1; i < word.length(); i++) {
            if(word.charAt(i) != word.charAt(i - 1)) {
                if(used[word.charAt(i) - 'a']) return;
                used[word.charAt(i) - 'a'] = true;
            }
        }
        answer++;
    }

    public static void input() {
        N = sc.nextInt();
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