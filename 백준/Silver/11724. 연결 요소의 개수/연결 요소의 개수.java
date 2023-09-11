import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NT = br.readLine().split(" ");
        int N = Integer.parseInt(NT[0]);
        int T = Integer.parseInt(NT[1]);

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[N+1];

        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int A = Integer.parseInt(inputs[0]);
            int B = Integer.parseInt(inputs[1]);
            graph[A].add(B);
            graph[B].add(A);
        }

        int element = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                element++;
                DFS(graph, visited, i);
            }
        }

        System.out.println(element);
    }

    public static void DFS(ArrayList<Integer>[] graph, boolean[] visited, int num) {
        if(visited[num]) return;

        visited[num] = true;
        for (int next : graph[num]) {
            if(!visited[next]) {
                DFS(graph, visited, next);
            }
        }
    }
}