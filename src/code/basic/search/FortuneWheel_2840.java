package code.basic.search;

import java.util.Arrays;
import java.util.Scanner;

public class FortuneWheel_2840 {
    public static void main_2840(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        int index = 0;

        while(T-- > 0) {
            index = (sc.nextInt() + index) % N;
            char c = sc.next().charAt(0);
            if(wheel[index] != '?' && wheel[index] != c) {
                System.out.print("!");
                return;
            }
            wheel[index] = c;
        }

        boolean[] chkExist = new boolean[26];
        for(int i = 0; i < N; i++) {
            char c = wheel[i];
            if(c == '?') continue;
            if(chkExist[c - 'A']) {
                System.out.print('!');
                return;
            }
            chkExist[c - 'A'] = true;
        }

        for(int i = 0; i < wheel.length; i++) {
            int outIndex = (index-- + N) % N;
            char wc = wheel[outIndex];
            System.out.print(wc);
        }
    }
}
