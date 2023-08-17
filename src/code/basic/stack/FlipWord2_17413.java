package code.basic.stack;

import java.util.Scanner;

public class FlipWord2_17413 {
    public static void main_17413 (String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length;) {
            if (s[i] == '<') {
                while (s[i] != '>') sb.append(s[i++]);
                sb.append(s[i++]);
            }
            else {
                int nextIndex = i;
                while (nextIndex < s.length && s[nextIndex] != ' ' && s[nextIndex] != '<')
                    nextIndex++;
                for (int j = nextIndex - 1; j >= i; j--)
                    sb.append(s[j]);
                if (nextIndex < s.length && s[nextIndex] == ' ') {
                    sb.append(" ");
                    nextIndex++;
                }
                i = nextIndex;
            }
        }
        System.out.println(sb);
    }
}
