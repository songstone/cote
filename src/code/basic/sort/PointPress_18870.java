package code.basic.sort;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PointPress_18870 {
    public static void main_18870(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> chkIntSet = new TreeSet<>();
        String[] inputArray = br.readLine().split(" ");
        int[] origin = new int[N];

        for (int i = 0; i < inputArray.length; i++) {
            int num = Integer.parseInt(inputArray[i]);
            chkIntSet.add(num);
            origin[i] = num;
        }

        Map<Integer, Integer> answerMap = new HashMap<>();
        int index = 0;
        for (int i : chkIntSet) {
            answerMap.put(i, index++);
        }

        for (int i = 0; i < origin.length; i++) {
            bw.write(answerMap.get(origin[i]) + " ");
        }
        bw.flush();
    }
}
