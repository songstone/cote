package code.basic.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld_4949 {
    public static void main_4949(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            boolean isBalanced = true;
            char[] charArr = str.toCharArray();
            for (char ch : charArr) {
                if (ch == '(') stack.push(1);

                else if (ch == '[') stack.push(2);

                else if (ch == ')' || ch == ']') {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    int chk = stack.pop();
                    boolean flag = ch == ')' ? chk == 1 : chk == 2;
                    if (!flag) {
                        isBalanced = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) isBalanced = false;

            System.out.println(isBalanced ? "yes" : "no");

            while(!stack.isEmpty()) stack.pop();
        }
    }
}
