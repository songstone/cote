import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] minusDiv = input.split("-");

        int answer = sumStr(minusDiv[0]);
        for (int i = 1; i < minusDiv.length; i++) {
            answer -= sumStr(minusDiv[i]);
        }

        System.out.println(answer);
    }

    public static int sumStr(String str) {
        String[] nums = str.split("\\+");
        int sum = Integer.parseInt(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            sum += Integer.parseInt(nums[i]);
        }
        return sum;
    }

}
