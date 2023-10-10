import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] chkArray;

        for (int i = 1; i <= N ; i++) {
            int walkSum = 0;
            chkArray = new int[20];
            int testCaseNum = sc.nextInt();
            chkArray[0] = sc.nextInt();
            for (int j = 1; j < chkArray.length; j++) {
                int stu = sc.nextInt();
                boolean stand = false;
                for (int k = 0; k < j ; k++) {
                    if(chkArray[k] > stu) {
                        walkSum += goBack(k,j,chkArray);
                        chkArray[k] = stu;
                        stand = true;
                        break;
                    }
                }
                if(!stand) chkArray[j] = stu;
            }
            System.out.println(testCaseNum + " " + walkSum);
        }
    }

    public static int goBack(int index, int length ,int[] array) {
        int walkCount = 0;
        for (int i = length-1 ; i >= index; i--) {
            array[i+1] = array[i];
            walkCount++;
        }
        return walkCount;
    }
}
