package code.basic.queue;

import java.io.*;
import java.util.PriorityQueue;

public class AbsHeap_11286 {
    public static void main_11286(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) ->
            Math.abs(i1) == Math.abs(i2) ? i1 - i2 : Math.abs(i1) - Math.abs(i2));

        while (N-- > 0) {
            String cmd = br.readLine();

            if(cmd.equals("0")) {
                if(queue.isEmpty()) bw.write(0 + "\n");
                else bw.write(queue.poll() + "\n");
            } else {
                queue.add(Integer.parseInt(cmd));
            }
        }
        bw.flush();
    }
}
