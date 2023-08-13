package code.basic.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Jumong_1940 {
    public static void main_1940(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] ingredients = new int[N];
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            ingredients[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(ingredients);

        int answer = 0;
        int leftIndex = 0;
        int rightIndex = N-1;

        while(leftIndex < rightIndex) {
            int chkSum = ingredients[leftIndex] + ingredients[rightIndex];
            if(chkSum == M) {
                leftIndex++;
                answer++;
            } else if(chkSum < M) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        System.out.println(answer);
    }
}
