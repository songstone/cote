package code.basic.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence_1874 {
    public static void main_1874(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        boolean enable = true;
        int currentNum = 1;
        while(N-- > 0) {
            int seq = Integer.parseInt(br.readLine());
            if (seq > stack.peek()) {
                while(seq != stack.peek()) {
                    sb.append('+');
                    stack.push(currentNum++);
                }
                sb.append('-');
                stack.pop();
            } else if (seq == stack.peek()) {
                sb.append('-');
                stack.pop();
            } else {
                enable = false;
                break;
            }
        }

        if(enable) {
            char[] arr = sb.toString().toCharArray();
            for (char ch : arr) {
                System.out.println(ch);
            }
        } else {
            System.out.println("NO");
        }
    }
}
