import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] alphaValue = new int[26];

        while (N-- > 0) {
            char[] alphaString = sc.next().toCharArray();

            int weight = 1;
            for (int i = alphaString.length - 1; i >= 0; i--) {
                alphaValue[alphaString[i] - 'A'] += 1 * weight;
                weight *= 10;
            }
        }
        Arrays.sort(alphaValue);

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += alphaValue[25 - i] * (9-i);
        }
        System.out.println(answer);
    }
}

