package code.basic.string;

import java.util.Scanner;

public class SaltBomb_13223 {
    public static void main_13223(String[] args) {
        Scanner sc = new Scanner(System.in);

        String now = sc.next();
        String targetTime = sc.next();

        String[] nowArray = now.split(":");
        String[] targetArray = targetTime.split(":");

        int nowHour = Integer.parseInt(nowArray[0]);
        int nowMinute = Integer.parseInt(nowArray[1]);
        int nowSecond = Integer.parseInt(nowArray[2]);

        int targetHour = Integer.parseInt(targetArray[0]);
        int targetMinute = Integer.parseInt(targetArray[1]);
        int targetSecond = Integer.parseInt(targetArray[2]);

        int nowSecondAmount = nowHour * 3600 + nowMinute * 60 + nowSecond;
        int targetSecondAmount = targetHour * 3600 + targetMinute * 60 + targetSecond;

        int needSecondAmount = targetSecondAmount - nowSecondAmount;
        if (needSecondAmount <= 0) needSecondAmount += 3600 * 24;

        int needHour = needSecondAmount / 3600;
        int needMinute = (needSecondAmount % 3600) / 60;
        int needSecond = needSecondAmount % 60;

        System.out.println(String.format("%02d:%02d:%02d", needHour, needMinute, needSecond));
    }
}
