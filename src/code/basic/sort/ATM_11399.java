package code.basic.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM_11399 {
    public static void main_11399(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        insertionSort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * (nums.length - i);
        }
        System.out.println(sum);
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int targetIndex = i - 1;
            while (targetIndex >= 0 && num < nums[targetIndex]) {
                nums[targetIndex + 1] = nums[targetIndex];
                targetIndex--;
            }
            nums[targetIndex + 1] = num;
        }
    }
}
