import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean find = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph[A].add(B);
            graph[B].add(A);
        }

        for (int i = 0; i < N; i++) {
            findRelation(i, 1);
            if(find) break;
        }

        System.out.println(find ? 1 : 0);
    }

    public static void findRelation(int num, int depth) {
        if(depth == 5) {
            find = true;
            return;
        }

        visited[num] = true;
        for (int i : graph[num]) {
            if(!visited[i]) findRelation(i, depth + 1);
        }
        visited[num] = false;
    }
}
