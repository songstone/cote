package code.basic.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Router_15828 {
    public static void main_15828(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        while (true) {
            int packet = Integer.parseInt(br.readLine());
            if(packet == -1) break;

            if(packet == 0) queue.poll();
            else {
                if(queue.size() == N) continue;
                queue.add(packet);
            }
        }

        if(queue.isEmpty()) bw.write("empty");
        else {
            while(!queue.isEmpty()) {
                bw.write(queue.poll() + " ");
            }
        }
        bw.flush();
    }
}
