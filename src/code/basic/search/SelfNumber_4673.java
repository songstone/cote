package code.basic.search;

public class SelfNumber_4673 {
    public static void main_4673(String[] args) {
        boolean[] existArray = new boolean[10001];
        int i = 0;
        while (++i < 10000) {
            if(existArray[i]) {
                continue;
            }
            int num = i;
            while(num <= 10000) {
                num = num + sumNum(num);
                if(num > 10000 || existArray[num]) break;
                existArray[num] = true;
            }
        }

        for (int j = 1; j < existArray.length; j++) {
            if(!existArray[j]) System.out.println(j);
        }
    }

    public static int sumNum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
