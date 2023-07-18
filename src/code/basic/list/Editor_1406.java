package code.basic.list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Editor_1406 {
    public static void main_1406(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        List<Character> inputList = new LinkedList<>();
        for (char ch : input) {
            inputList.add(ch);
        }

        int T = sc.nextInt();

        ListIterator<Character> it = inputList.listIterator(inputList.size());
        while (T-- > 0) {
            char command = sc.next().charAt(0);

            if ('L' == command) {
                if(it.hasPrevious()) it.previous();
            } else if ('D' == command) {
                if(it.hasNext()) it.next();
            } else if ('B' == command) {
                if(it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else {
                it.add(sc.next().charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : inputList) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
