package code.basic.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class KeyLogger_5397 {
    public static void main_5397(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        Deque<Character> cursorLeft = new ArrayDeque<>();
        Deque<Character> cursorRight = new ArrayDeque<>();
        while (T-- > 0) {
            char[] chars = br.readLine().toCharArray();

            for (char ch : chars) {
                if (ch == '<') {
                    if (!cursorLeft.isEmpty()) cursorRight.offerLast(cursorLeft.pollLast());
                } else if (ch == '>') {
                    if (!cursorRight.isEmpty()) cursorLeft.offerLast(cursorRight.pollLast());
                } else if (ch == '-') {
                    if (!cursorLeft.isEmpty()) cursorLeft.pollLast();
                } else {
                    cursorLeft.offerLast(ch);
                }
            }

            while (!cursorLeft.isEmpty()) sb.append(cursorLeft.pollFirst());
            while (!cursorRight.isEmpty()) sb.append(cursorRight.pollLast());

            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
