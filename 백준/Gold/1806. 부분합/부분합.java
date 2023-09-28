import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NS = br.readLine().split(" ");
        int N = Integer.parseInt(NS[0]);
        int S = Integer.parseInt(NS[1]);

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(inputs[i]);
            if(input >= S) {
                System.out.println(1);
                return;
            }
            nums[i] = input;
        }

        int answerLen = N + 1;

        int endIndex = 0;
        int chkSum = nums[0];
        for (int i = 0; i < N; i++) {
            while (chkSum < S && endIndex < N - 1) {
                chkSum += nums[++endIndex];
            }
            if(chkSum >= S) answerLen = Math.min(answerLen, endIndex - i + 1);
            chkSum -= nums[i];
        }
        System.out.println(answerLen != (N+1) ? answerLen : 0);
    }
}