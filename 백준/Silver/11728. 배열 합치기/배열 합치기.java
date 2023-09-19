import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arrayN = new int[N];
        int[] arrayM = new int[M];
        int[] answer = new int[N + M];

        for (int i = 0; i < N; i++) {
            arrayN[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            arrayM[i] = sc.nextInt();
        }

        int indexN = 0;
        int indexM = 0;
        int answerIndex = 0;

        while(indexN < N && indexM < M) {
            int n = arrayN[indexN];
            int m = arrayM[indexM];
            if(n <= m) {
                answer[answerIndex++] = n;
                indexN++;
            } else {
                answer[answerIndex++] = m;
                indexM++;
            }
        }

        while(indexN < N) answer[answerIndex++] = arrayN[indexN++];
        while(indexM < M) answer[answerIndex++] = arrayM[indexM++];

        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}