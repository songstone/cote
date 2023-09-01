package code.basic.binarySearch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FindNumber_1920 {
    public static void main_1920(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int M = sc.nextInt();
        while (M-- > 0) {
            System.out.println(findNum(nums, sc.nextInt()) ? 1 : 0);
        }
    }

    public static boolean findNum(int[] nums, int num) {
        int startIndex = 0;
        int endIndex = nums.length-1;
        while (startIndex <= endIndex) {
            int chkIndex = (startIndex + endIndex) / 2;
            int chkNum = nums[chkIndex];
            if (chkNum == num) {
                return true;
            }
            if(chkNum < num) {
                startIndex = chkIndex+1;
            } else {
                endIndex = chkIndex-1;
            }
        }
        return false;
    }
}
