import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(nums);

        int answer = 0;
        for (int i = N-1; i >= 0; i--) {
            int leftIndex = 0;
            int rightIndex = N-1;
            while(leftIndex < rightIndex) {
                int chkSum = nums[leftIndex] + nums[rightIndex];
                if(chkSum == nums[i]) {
                    if(leftIndex == i) {
                        leftIndex++;
                        continue;
                    }
                    if(rightIndex == i) {
                        rightIndex--;
                        continue;
                    }
                    answer++;
                    break;
                } else if(chkSum > nums[i]) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }

        System.out.println(answer);
    }
}