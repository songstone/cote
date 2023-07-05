package code.basic.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class FindNumber_1920 {
    public static void main_1920(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = sc.nextInt();
        }
        Arrays.sort(inputs);

        int T = sc.nextInt();
        while (T-- > 0) {
            System.out.println(isExist(inputs, sc.nextInt()) ? 1 : 0);
        }
    }

    public static boolean isExist(int[] arr, int X) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if(arr[m] < X) l = m + 1;
            else if(arr[m] > X) r = m -1;
            else return true;
        }
        return false;
    }
}
