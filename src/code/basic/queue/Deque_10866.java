package code.basic.queue;

import java.io.*;
import java.util.LinkedList;

public class Deque_10866 {
    public static void main_10866(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque();
        while (N-- > 0) {
            String[] command = br.readLine().split(" ");

            if(command[0].equals("push_front")) deque.pushFront(Integer.parseInt(command[1]));
            else if(command[0].equals("push_back")) deque.pushBack(Integer.parseInt(command[1]));
            else if(command[0].equals("pop_front")) bw.write(deque.popFront() + "\n");
            else if(command[0].equals("pop_back")) bw.write(deque.popBack() + "\n");
            else if(command[0].equals("size")) bw.write(deque.size() + "\n");
            else if(command[0].equals("empty")) bw.write(deque.empty() + "\n");
            else if(command[0].equals("front")) bw.write(deque.front() + "\n");
            else if(command[0].equals("back")) bw.write(deque.back() + "\n");
        }
        bw.flush();
    }

    static class MyDeque {
        private LinkedList<Integer> list = new LinkedList<>();

        public void pushFront(int num) {
            list.addFirst(num);
        }

        public void pushBack(int num) {
            list.addLast(num);
        }

        public int popFront() {
            if (list.size() == 0) return -1;
            return list.pollFirst();
        }

        public int popBack() {
            if (list.size() == 0) return -1;
            return list.pollLast();
        }

        public int size() {
            return list.size();
        }

        public int empty() {
            return list.isEmpty() ? 1 : 0;
        }

        public int front() {
            if (list.size() == 0) return -1;
            return list.peekFirst();
        }

        public int back() {
            if (list.size() == 0) return -1;
            return list.peekLast();
        }
    }
}
