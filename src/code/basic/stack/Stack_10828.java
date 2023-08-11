package code.basic.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack_10828 {
    public static void main_10828(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        int topIndex = -1;
        int size = 0;
        while (N-- > 0) {
            String[] inputs = br.readLine().split(" ");
            String cmd = inputs[0];
            if(cmd.equals("push")) {
                array[++topIndex] = Integer.parseInt(inputs[1]);
                size++;
            } else if (cmd.equals("pop")) {
                if(size == 0) System.out.println(-1);
                else {
                    System.out.println(array[topIndex--]);
                    size--;
                }
            } else if (cmd.equals("size")) {
                System.out.println(size);
            } else if (cmd.equals("empty")) {
                System.out.println(size == 0 ? 1 : 0);
            } else if (cmd.equals("top")) {
                if(size == 0) System.out.println(-1);
                else System.out.println(array[topIndex]);
            }
        }
    }
}
