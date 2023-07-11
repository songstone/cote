package code.basic.twoPointer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SelectNum_2230 {
    public static void main_2230(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int validMin = Integer.MAX_VALUE;
        int endIndex = 0;
        for (int i = 0; i < N; i++) {
            while (nums[endIndex] - nums[i] < M && endIndex < N - 1) {
                endIndex++;
            }
            if (nums[endIndex] - nums[i] >= M) {
                validMin = Math.min(validMin, nums[endIndex] - nums[i]);
            }
        }

        System.out.println(validMin);
    }
}
