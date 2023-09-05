import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static Queue<Integer> bfsQueue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph[A].add(B);
            graph[B].add(A);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        DFS(K);
        initVisited();
        System.out.println();
        BFS(K);
    }

    public static void DFS(int i) {
        if(visited[i]) return;
        visited[i] = true;
        System.out.print(i + " ");
        for (int num : graph[i]) {
            DFS(num);
        }
    }

    public static void BFS(int i) {
        if(visited[i]) return;
        visited[i] = true;
        System.out.print(i + " ");
        for (int num : graph[i]) {
            bfsQueue.add(num);
        }

        while (!bfsQueue.isEmpty()) {
            BFS(bfsQueue.poll());
        }
    }

    public static void initVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }
}
