import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        char[] target = sc.next().toCharArray();

        int minCount = target.length;

        for (int i = 0; i <= target.length - input.length ; i++) {
            int count = 0;
            for (int j = 0; j < input.length; j++) {
                if(input[j] != target[i+j]) count++;
            }
            minCount = Math.min(count, minCount);
        }

        System.out.println(minCount);
    }
}