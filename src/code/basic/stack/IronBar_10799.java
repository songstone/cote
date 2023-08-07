package code.basic.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IronBar_10799 {
    public static void main_10799(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();

        int openCnt = 0;
        int barCnt = 0;

        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            if(ch == '(') openCnt++;
            else {
                openCnt--;
                if(str[i-1] == '(') {
                    barCnt += openCnt;
                }
                else {
                    barCnt += 1;
                }
            }
        }

        System.out.println(barCnt);
    }
}
