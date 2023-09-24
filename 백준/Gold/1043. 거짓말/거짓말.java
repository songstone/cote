import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static CustomScanner sc = new CustomScanner();

    static int N, M, answer;
    static int[] array, trustPerson, trustGroup;
    static int[][] parties;

    public static void main(String[] args) throws IOException {
        input();
        unionParties();
        getTrustGroup();
        checkParties();
        System.out.println(answer);
    }

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        array = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = i;
        }

        trustPerson = new int[sc.nextInt()];
        for (int i = 0; i < trustPerson.length; i++) {
            trustPerson[i] = sc.nextInt();
        }
        trustGroup = new int[trustPerson.length];

        parties = new int[M][];
        for (int i = 0; i < M; i++) {
            int[] party = new int[sc.nextInt()];
            for (int j = 0; j < party.length; j++) {
                party[j] = sc.nextInt();
            }
            parties[i] = party;
        }
    }

    static void unionParties() {
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < parties[i].length; j++) {
                union(parties[i][j - 1], parties[i][j]);
            }
        }
    }

    static void getTrustGroup() {
        for (int i = 0; i < trustPerson.length; i++) {
            trustGroup[i] = find(trustPerson[i]);
        }
    }

    private static void checkParties() {
        for (int i = 0; i < M; i++) {
            boolean enable = true;
            int partyIndex = find(parties[i][0]);
            for (int j = 0; j < trustGroup.length; j++) {
                if (trustGroup[j] == partyIndex) {
                    enable = false;
                    break;
                }
            }
            if (enable) answer++;
        }
    }

    static void union(int a, int b) {
        int aRepIndex = find(a);
        int bRepIndex = find(b);

        array[bRepIndex] = array[aRepIndex];
    }

    static int find(int a) {
        if (array[a] == a) return a;
        int nextIndex = find(array[array[a]]);
        array[a] = nextIndex;
        return nextIndex;
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