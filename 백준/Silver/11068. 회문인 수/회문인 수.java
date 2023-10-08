import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int result = 0;
            long chkNum = sc.nextLong();
            for(int j = 2; j <= 64 ; j++) {
                String chkString = "";
                long K = chkNum;
                while(K > 0) {
                    chkString += (char)(K % j);
                    K /= j;
                }
                if(isPalindrome(chkString)) {
                    result = 1;
                    break;
                }
            }
            System.out.println(result);
        }
    }

    public static boolean isPalindrome(String chk) {
        for (int i = 0, j = chk.length()-1 ; i <= j; i++, j--) {
            if(chk.charAt(i) != chk.charAt(j)) return false;
        }
        return true;
    }
}
