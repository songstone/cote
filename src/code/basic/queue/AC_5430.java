package code.basic.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AC_5430 {
    public static void main_5430(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            String[] nums = br.readLine()
                .replace("[","")
                .replace("]","")
                .split(",");

            int[] numArray = new int[N];
            for (int i = 0; i < N; i++) {
                numArray[i] = Integer.parseInt(nums[i]);
            }

            MyArrayUtil util = new MyArrayUtil(numArray);

            boolean error = false;
            for (char command : commands) {
                if(command == 'R') util.reverse();
                else {
                    if(util.empty()) {
                        error = true;
                        break;
                    } else {
                        util.poll();
                    }
                }
            }

            if(error) System.out.println("error");
            else {
                sb.append("[");
                while(!util.empty()) {
                    sb.append(util.poll() + "");
                    if(!util.empty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
                sb.setLength(0);
            }
        }
    }

    static class MyArrayUtil {
        private int direction = 1;
        private LinkedList<Integer> list = new LinkedList<>();

        public MyArrayUtil(int[] array) {
            for (int i : array) {
                list.add(i);
            }
        }

        public void reverse() {
            if(direction == 1) direction = -1;
            else direction = 1;
        }

        public int poll() {
            return direction == 1 ? list.pollFirst() : list.pollLast();
        }

        public boolean empty() {
            return list.isEmpty();
        }
    }
}
