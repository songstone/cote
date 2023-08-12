package code.basic.stack;

import java.util.Scanner;

public class GoodWord_3986 {
    public static void main_3986 (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int ans = 0;
        while (N-- > 0) {
            char[] input = sc.next().toCharArray();
            char[] st = new char[input.length];
            int idx = -1;
            for (char ch : input) {
                if (idx < 0) st[++idx] = ch;
                else if (st[idx] == ch) idx--;
                else st[++idx] = ch;
            }
            if (idx < 0) ans++;
        }
        System.out.println(ans);
    }
}
