package code.basic.binarySearch;

import java.io.IOException;
import java.util.Scanner;

public class GuitarLesson_2343 {
    static int limitCnt;
    public static void main_2343(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        limitCnt = sc.nextInt();

        int[] lectures = new int[N];
        for (int i = 0; i < N; i++) {
            lectures[i] = sc.nextInt();
        }

        int startLength = 1;
        int endLength = N*10000;
        int answer = 0;
        while(startLength <= endLength) {
            int length = (startLength + endLength) / 2;
            if(chkLength(lectures, length)) {
                endLength = length - 1;
                answer = length;
            } else {
                startLength = length + 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean chkLength(int[] lectures, int length) {
        int chkSum = 0;
        int bluRayCnt = 1;
        for (int lecture : lectures) {
            if(lecture > length) return false;
            if(chkSum + lecture > length) {
                if(++bluRayCnt > limitCnt) return false;
                chkSum = 0;
            }
            chkSum += lecture;
        }
        return true;
    }
}
