package code.basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CardSort_1715 {
    public static void main_1715(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> cardQueue = new PriorityQueue<>();
        while (N-- > 0) {
            cardQueue.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(cardQueue.size() > 1) {
            int count = cardQueue.poll() + cardQueue.poll();
            answer += count;
            cardQueue.offer(count);
        }

        System.out.println(answer);
    }
}
