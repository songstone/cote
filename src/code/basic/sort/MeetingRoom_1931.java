package code.basic.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoom_1931 {
    public static void main_1931(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Meeting[] meetingArr = new Meeting[N];

        for (int i = 0; i <N ; i++) {
            meetingArr[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(meetingArr, (m1, m2) -> m1.end != m2.end ? m1.end - m2.end : m1.start - m2.start);

        int count = 1;
        Meeting chkMeeting = meetingArr[0];
        for (int i = 1; i < meetingArr.length; i++) {
            if(chkMeeting.end <= meetingArr[i].start) {
                chkMeeting = meetingArr[i];
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
    }}
