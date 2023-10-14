import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        int K = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        char[][] inputs = new char[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char[] inputArr = sc.next().toCharArray();
            for (int j = 1; j <= M; j++) {
                inputs[i][j] = inputArr[j - 1];
            }
        }

        while(T-- > 0) {
            int[][] sum = getSum(inputs);
            for (int i = 1; i <= N ; i++) {
                for (int j = 1; j <= M; j++) {
                    int lives = countLife(sum, K, i ,j);
                    if(inputs[i][j] == '*') {
                        lives--;
                        if(lives < a || lives > b) {
                            inputs[i][j] = '.';
                        }
                    }
                    else if(lives > a && lives <= b) {
                        inputs[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(inputs[i][j]);
            }
            System.out.println();
        }
    }

    public static int countLife(int[][] sum, int K, int x, int y) {
        int startX = Math.max(x - K, 1);
        int startY = Math.max(y - K, 1);
        int endX = Math.min(x + K, sum.length - 1);
        int endY = Math.min(y + K, sum[0].length - 1);

        return sum[endX][endY] - sum[startX-1][endY] - sum[endX][startY-1] + sum[startX-1][startY-1];
    }

    public static int[][] getSum(char[][] inputs) {
        int[][] sum = new int[inputs.length][inputs[0].length];

        for (int i = 1; i < inputs.length; i++) {
            for (int j = 1; j < inputs[0].length; j++) {
                sum[i][j] = (inputs[i][j] == '*' ? 1 : 0) + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        return sum;
    }

}