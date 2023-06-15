package code.basic.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SerialNum_1431 {
    public static void main_1431(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Guitar[] guitars = new Guitar[N];

        for (int i = 0; i < N; i++) {
            guitars[i] = new Guitar(sc.next());
        }

        Arrays.sort(guitars);

        for (Guitar guitar : guitars) {
            System.out.println(guitar.serial);
        }
    }

    public static class Guitar implements Comparable<Guitar>{
        String serial;

        public Guitar(String serial) {
            this.serial = serial;
        }

        private int chkSerialNum() {
            char[] charArr = serial.toCharArray();
            int sum = 0;
            for (int i = 0; i < charArr.length; i++) {
                int chk = charArr[i] - '0';
                if(chk >= 0 && chk < 10) sum += chk;
            }
            return sum;
        }

        @Override
        public int compareTo(Guitar o) {
            if(this.serial.length() == o.serial.length()) {
                if(this.chkSerialNum() == o.chkSerialNum()) return this.serial.compareTo(o.serial);
                else return this.chkSerialNum() - o.chkSerialNum();
            }
            else return this.serial.length() - o.serial.length();
        }
    }
}
