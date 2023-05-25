package code.basic.search;

import java.util.Scanner;

public class AlpsVote_2817 {
    static class Score {
        Score(int staffIndex, double value) {
            this.staffIndex = staffIndex;
            this.value = value;
        }
        int staffIndex;
        double value;
    }

    public static void sortScoresDesc(Score[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i].value > array[j].value) {
                    Score temp = array[i];
                    for (int k = i; k > j; k--) {
                        array[k] = array[k-1];
                    }
                    array[j] = temp;
                }
            }
        }
    }

    public static void main_2817(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        double validCnt = N * 0.05;
        boolean[] validCandidate = new boolean[26];
        int[] staffVote = new int[26];
        int candidateCount = 0;

        for (int i = 0; i < T; i++) {
            String name = sc.next();
            int vote = sc.nextInt();
            if (vote >= validCnt) {
                int index = name.charAt(0) - 'A';
                validCandidate[index] = true;
                staffVote[index] = vote;
                candidateCount++;
            }
        }

        Score[] scores = new Score[candidateCount * 14];
        int scoreIndex = 0;
        for (int i = 0; i < 26; i++) {
            if(validCandidate[i]){
                for (int j = 1; j <= 14; j++) {
                    scores[scoreIndex++] = new Score(i, (double) staffVote[i] / j);
                }
            }
        }

        sortScoresDesc(scores);

        int[] answer = new int[26];
        for (int i = 0; i < 14; i++) {
            answer[scores[i].staffIndex]++;
        }

        for (int i = 0; i < 26; i++) {
            if (validCandidate[i]) {
                System.out.println((char) (i + 'A') + " " + answer[i]);
            }
        }
    }
}
