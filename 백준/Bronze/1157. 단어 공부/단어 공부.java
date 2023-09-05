import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int[] count = getUpperAlphabetCount(input);

        int max = 0;
        char target = '?';

        for (int i = 0; i < count.length; i++) {
            if(count[i] > max) {
                max = count[i];
                target = (char) (i + 'A');
            } else if(count[i] == max) {
                target = '?';
            }
        }
        System.out.println(target);
    }

    public static int[] getUpperAlphabetCount(String str) {
        str = str.toUpperCase();
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'A']++;
        }
        return count;
    }
}
