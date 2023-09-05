import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] wordArr = new String[N];
		
		for(int i=0; i < wordArr.length; i++) {
			wordArr[i] = sc.next();
		}
		
		Arrays.sort(wordArr, (s1, s2) -> s1.length() != s2.length() ? -(s2.length() - s1.length()) : s1.compareTo(s2));
		
		String preWord = "";
		for(int i = 0; i < wordArr.length; i++) {
			String word = wordArr[i];
			if(word.equals(preWord)) continue;
			System.out.println(word);
			preWord = word;
		}
	}
}
