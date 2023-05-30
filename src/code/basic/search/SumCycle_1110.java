package code.basic.search;

import java.util.Scanner;

public class SumCycle_1110 {
    public static void main_1110(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num = N;
        int count = 0;
        while(true) {
            num = (num%10)*10 + (num/10 + num%10)%10;
            count++;
            if(num == N) break;
        }
        System.out.println(count);
    }
}
