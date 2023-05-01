package code.basic.string;

import java.util.Scanner;

public class Ant_10158 {
    public static void main_10158(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int t = sc.nextInt();

        int xMove = (t + x) % (2*w);
        int yMove = (t + y) % (2*h);

        int xPosition = xMove > w ? 2*w - xMove : xMove;
        int yPosition = yMove > h ? 2*h - yMove : yMove;

        System.out.println(xPosition + " " + yPosition);
    }
}
