package code.basic.queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintQueue_1966 {
    static class Document {
        int initIndex;
        int priority;

        public Document(int initIndex, int priority) {
            this.initIndex = initIndex;
            this.priority = priority;
        }
    }

    public static void main_1966(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int targetIndex = sc.nextInt();

            int printCnt = 0;

            Queue<Document> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                queue.add(new Document(i, sc.nextInt()));
            }

            while (!queue.isEmpty()) {
                Document document = queue.poll();
                if (isExistHigher(document.priority, queue)) queue.add(document);
                else {
                    printCnt++;
                    if (document.initIndex == targetIndex) System.out.println(printCnt);
                }
            }
        }
    }

    public static boolean isExistHigher(int priority, Queue<Document> queue) {
        return queue.stream()
            .filter(document -> document.priority > priority)
            .findAny()
            .isPresent();
    }
}
