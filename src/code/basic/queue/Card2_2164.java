package code.basic.queue;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Card2_2164 {
    public static void main_2164(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> cards = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            cards.offerFirst(i+1);
        }

        while(cards.size() != 1) {
            cards.pollLast();
            cards.offerFirst(cards.pollLast());
        }

        System.out.println(cards.pollLast());
    }
}
