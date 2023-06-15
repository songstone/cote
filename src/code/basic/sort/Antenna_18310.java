package code.basic.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Antenna_18310 {
    public static void main_18310(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }
        Arrays.sort(houses);
        System.out.println(houses[(N-1)/2]);
    }
}
