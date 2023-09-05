import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Meeting[] meetingArr = new Meeting[N];
		
		for (int i = 0; i <N ; i++) {
			meetingArr[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(meetingArr, (m1, m2) -> m1.end != m2.end ? m1.end - m2.end : m1.start - m2.start);
		
		int count = 0;
		int chkEnd = 0;
		for (int i = 0; i < meetingArr.length; i++) {
			if(chkEnd <= meetingArr[i].start) {
				chkEnd = meetingArr[i].end;
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static class Meeting{ 
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
