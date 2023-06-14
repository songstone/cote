package code.basic.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FrequencySort_2910 {
    public static void main_2910(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Temp[] temps = new Temp[N];
        for (int i = 0; i < N; i++) {
            temps[i] = new Temp(sc.nextInt(), i);
        }

        Arrays.sort(temps, Comparator.comparingInt(t -> t.num));

        Frequency[] frequencies = new Frequency[N];
        int index = 0;
        frequencies[index] = new Frequency(temps[0].num, 1, temps[0].index);
        for (int i = 1; i < temps.length; i++) {
            if(temps[i-1].num != temps[i].num)
                frequencies[++index] = new Frequency(temps[i].num, 1, temps[i].index);
            else
                frequencies[index].count++;
        }

        Arrays.sort(frequencies, 0, index + 1, (f1, f2) -> f1.count == f2.count ? f1.originIndex - f2.originIndex : f2.count - f1.count);

        for (int i = 0; i <= index; i++) {
            while(frequencies[i].count-- > 0)
                System.out.print(frequencies[i].num + " ");
        }

    }

    public static class Frequency{
        int num;
        int count;
        int originIndex;

        public Frequency(int num, int count, int originIndex) {
            this.num = num;
            this.count = count;
            this.originIndex = originIndex;
        }
    }

    public static class Temp {
        int num;
        int index;

        public Temp(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
