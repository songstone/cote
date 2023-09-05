import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean[] buttonEnable = new boolean[10];
        for (int i = 0; i < 10; i++) {
            buttonEnable[i] = true;
        }

        int currentChannel = 100;

        Scanner sc = new Scanner(System.in);
        int targetChannel = sc.nextInt();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            buttonEnable[sc.nextInt()] = false;
        }

        int answer = Math.abs(currentChannel - targetChannel);

        for (int i = 0; i < answer; i++) {
            int[] numbers = {targetChannel + i, targetChannel - i};
            for (int number : numbers) {
                if(number >= 0 && isEnable(buttonEnable, number)) answer = Math.min(answer, Integer.toString(number).length() + i);
            }
        }

        System.out.println(answer);
    }

    public static boolean isEnable(boolean[] enable, int channel) {
        if(channel == 0) return enable[0];
        while(channel > 0) {
            if(!enable[channel % 10]) return false;
            channel /= 10;
        }
        return true;
    }
}