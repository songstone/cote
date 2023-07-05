package code.basic.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class StringSet_14425 {
    public static void main_14425(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        String[] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = sc.next();
        }
        Arrays.sort(inputs);

        int answer = 0;
        while(T-- > 0) {
            if(isExist(inputs, sc.next())) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isExist(String[] arr, String key) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while(startIndex <= endIndex) {
            int chkIndex = (startIndex + endIndex) / 2;
            if(arr[chkIndex].compareTo(key) > 0) endIndex = chkIndex -1;
            else if(arr[chkIndex].compareTo(key) < 0) startIndex = chkIndex + 1;
            else return true;
        }

        return false;
    }
}
