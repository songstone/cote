package code.basic.parametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutTree_2805 {
    public static void main_2805(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Integer[] tree = new Integer[N];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(tree);

        int boundIndex = searchBoundTree(tree, M);
        long treeCutSum = sumTreeCut(tree, boundIndex);
        int validTreeCnt = tree.length - boundIndex;

        int needMeter = (M - (int) treeCutSum);

        int addMeter = (needMeter % validTreeCnt) != 0 ? needMeter / validTreeCnt + 1 : needMeter / validTreeCnt;

        System.out.println(tree[boundIndex] - addMeter);

    }

    public static int searchBoundTree(Integer[] tree, int M) {
        int startIndex = 0;
        int endIndex = tree.length - 1;
        int boundIndex = tree.length;

        while(startIndex <= endIndex) {
            int chkIndex = (startIndex + endIndex) / 2;
            if(sumTreeCut(tree, chkIndex) > M) startIndex = chkIndex + 1;
            else {
                endIndex = chkIndex - 1;
                boundIndex = chkIndex;
            }
        }
        return boundIndex;
    }

    public static long sumTreeCut(Integer[] tree, int index) {
        int standard = tree[index];
        long sum = 0;
        for (int i = index+1; i < tree.length; i++) {
            sum += tree[i] - standard;
        }
        return sum;
    }
}
