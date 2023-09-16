import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] prefixSum = new int[30];
        int count = 1;
        for (int i = 1; i < 30; i++) {
            count = count << 1;
            prefixSum[i] = prefixSum[i - 1] + count;
        }

        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int index = 0;

        for (int i = 0; i < prefixSum.length; i++) {
            if(prefixSum[i] < K && prefixSum[i+1] >= K) {
                index = i+1;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        int validRangeNum = K - prefixSum[index-1] - 1;
        for (int i = 1; i < index; i++) {
            char chk = (int) (validRangeNum/Math.pow(2, index - i)) == 1 ? '7' : '4';
            sb.append(chk);
            validRangeNum = (int) (validRangeNum % Math.pow(2, index - i));
        }
        sb.append(validRangeNum % 2 == 1 ? '7' : '4');
        System.out.println(sb);
    }
}