package code.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Candidate_1713 {
    public static void main_1713(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int frameCnt = sc.nextInt();
        int voteNumber = sc.nextInt();

        List<Student> frame = new ArrayList<>(frameCnt);

        for (int i = 0; i < voteNumber; i++) {
            boolean isPosted = false;
            int number = sc.nextInt();

            for (int j = 0; j < frame.size(); j++) {
                Student chk = frame.get(j);
                if (chk.number == number) {
                    chk.voteCnt += 1;
                    isPosted = true;
                    break;
                }
            }

            if (!isPosted) {
                if (frame.size() < frameCnt) {
                    frame.add(new Student(number, 1, i));
                } else {
                    Collections.sort(frame, (s1, s2) -> s1.voteCnt == s2.voteCnt ? s1.postOrder - s2.postOrder : s1.voteCnt - s2.voteCnt);
                    frame.set(0, new Student(number, 1, i));
                }
            }
        }

        Collections.sort(frame, (s1, s2) -> s1.number - s2.number);
        for (Student student : frame) {
            System.out.print(student.number);
            System.out.print(" ");
        }

    }
    static class Student {
        int number;
        int voteCnt;
        int postOrder;

        public Student(int number, int voteCnt, int postOrder) {
            this.number = number;
            this.voteCnt = voteCnt;
            this.postOrder = postOrder;
        }
    }
}

