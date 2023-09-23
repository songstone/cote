import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static CustomScanner sc = new CustomScanner();
    static int[] cups = new int[3];

    static boolean[][] checked;

    static List<Integer> answer = new ArrayList<>();
    static Command[] commands;

    public static void main(String[] args) throws IOException {
        input();
        setCommands();
        DFS(new WaterSnapshot(0,0));

        answer.stream()
            .distinct()
            .sorted()
            .forEach(i -> System.out.print(i + " "));
    }

    static void input() {
        cups[0] = sc.nextInt();
        cups[1] = sc.nextInt();
        cups[2] = sc.nextInt();
        checked = new boolean[201][201];
    }

    static void setCommands() {
        commands = new Command[6];
        commands[0] = new Command(0, 1);
        commands[1] = new Command(0, 2);
        commands[2] = new Command(1, 0);
        commands[3] = new Command(1, 2);
        commands[4] = new Command(2, 0);
        commands[5] = new Command(2, 1);
    }

    static void DFS(WaterSnapshot snapshot) {

        int a = snapshot.a;
        int b = snapshot.b;
        int c = snapshot.getC();

        if (snapshot.answer()) answer.add(snapshot.getC());

        if(!checked[a][b]) {
            checked[a][b] = true;
            for (int i = 0; i < 6; i++) {
                int[] waters = {a, b, c};
                executeCommand(waters, commands[i]);
                DFS(new WaterSnapshot(waters[0], waters[1]));
            }
        }
    }

    static void executeCommand(int[] waters, Command command) {
        int src = command.src;
        int des = command.des;

        waters[des] += waters[src];
        waters[src] = 0;
        if(waters[des] > cups[des]) {
            waters[src] = waters[des] - cups[des];
            waters[des] = cups[des];
        }
    }

    static class WaterSnapshot {
        int a;
        int b;

        public WaterSnapshot(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getC() {
            return cups[2] - a - b;
        }

        public boolean answer() {
            return a == 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WaterSnapshot snapshot = (WaterSnapshot) o;
            return a == snapshot.a && b == snapshot.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    static class Command {
        int src;
        int des;

        public Command(int src, int des) {
            this.src = src;
            this.des = des;
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