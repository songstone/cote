import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        Stack<Character> pStack = new Stack<>();

        boolean isPPAP = true;
        for (int i = 0; i < input.length; i++) {
            char ch = input[i];
            if(ch == 'P') pStack.push(ch);
            else {
                if(i == input.length -1 || pStack.size() < 2 || input[i+1] == 'A') {
                    isPPAP = false;
                    break;
                }
                pStack.pop();
                pStack.pop();
            }
        }
        if(pStack.size() > 1) isPPAP = false;

        System.out.println(isPPAP ? "PPAP" : "NP");
    }
}