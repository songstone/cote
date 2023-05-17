package code.basic.search;

import java.io.IOException;
import java.util.Scanner;

public class AcmHotel_10250 {
    public static void main_10250(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int H = sc.nextInt();
            int W = sc.nextInt();

            int order = sc.nextInt();

            int floor = order % H;
            int index = (order / H) + 1;

            if(floor == 0) {
                index -= 1;
                floor = H;
            }
            System.out.println(String.format("%d%02d",floor, index));
        }
    }
}
