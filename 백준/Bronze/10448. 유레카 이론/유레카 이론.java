import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int K = sc.nextInt();
            int[] nums = new int[50];
            int triNumCount = getTriNums(nums, K);
            System.out.println(isEureka(nums, triNumCount, K) ? 1 : 0);
        }

    }

    public static int getTriNums(int[] nums, int K) {
        int triNumCount = 0;
        for (int i = 1; ; i++) {
            int triNum = i*(i+1)/2;
            if(triNum >= K) break;
            nums[triNumCount++] = triNum;
        }
        return triNumCount;
    }

    public static boolean isEureka(int[] triNums, int triNumCount, int K) {
        for (int i = 0; i < triNumCount; i++) {
            for (int j = 0; j < triNumCount; j++) {
                for (int k = 0; k < triNumCount; k++) {
                    if(triNums[i] + triNums[j] + triNums[k] == K) return true;
                }
            }
        }
        return false;
    }
}
