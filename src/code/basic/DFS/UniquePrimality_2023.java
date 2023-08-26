package code.basic.DFS;

import java.util.Scanner;

public class UniquePrimality_2023 {
    public static void main_2023(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        search(N,2);
        search(N,3);
        search(N,5);
        search(N,7);
    }

    public static void search(int N, int num) {
        int jari = (int)(Math.log10(num)+1);
        if(jari == N) {
            if(isPrimality(num)) System.out.println(num);
            return;
        }

        for (int i = 1; i <= 9 ; i++) {
            if(isPrimality(num*10 + i)) {
                search(N, num*10 + i);
            }
        }
    }

    public static boolean isPrimality(int num) {
        if(num == 1) return false;
        int chk = 2;
        while (chk * chk <= num) {
            if(num % chk == 0) return false;
            chk++;
        }
        return true;
    }
}
