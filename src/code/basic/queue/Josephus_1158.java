package code.basic.queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus_1158 {
    public static void main_1158(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!queue.isEmpty()) {
            int num = queue.poll();
            if(++count % K == 0) {
                sb.append(num);
                if(!queue.isEmpty()) sb.append(", ");
            }
            else {
                queue.add(num);
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
