package code.basic.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus_1158 {
    public static void main_1158(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }

        sb.append("<");
        int count = 0;
        int index = 0;
        while(list.size() > 0) {
            int chkIndex = index % (list.size());
            if(++count == K) {
                sb.append(list.remove(chkIndex));
                if(list.size() != 0) sb.append(", ");
                index = chkIndex;
                count = 0;
            } else {
                index++;
            }
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}
