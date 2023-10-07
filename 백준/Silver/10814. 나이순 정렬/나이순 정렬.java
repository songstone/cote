import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Member[] memberArr = new Member[N];
		
		for (int i = 0; i < N; i++) {
			memberArr[i] = new Member(sc.nextInt(), sc.next(), i);
		}
		
		Arrays.sort(memberArr);
		
		for (int i = 0; i < memberArr.length; i++) {
			System.out.println(memberArr[i]);
		}
	}
	
	public static class Member implements Comparable<Member> {
		private int age;
		private String name;
		private int index;
		
		public Member(int age, String name, int index) {
			this.age = age;
			this.name = name;
			this.index = index;
		}

		@Override
		public int compareTo(Member o) {
			return age == o.age ? index - o.index : age - o.age; 
		}
		

		@Override
		public String toString() {
			return age + " " + name;
		}

		public int getAge() {
			return age;
		}

		public String getName() {
			return name;
		}
	}
}
