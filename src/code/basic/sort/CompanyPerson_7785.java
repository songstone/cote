package code.basic.sort;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CompanyPerson_7785 {
    public static void main_7785(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Set<String> companyPeople = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String name= sc.next();
            String enterOrLeave = sc.next();
            if(enterOrLeave.equals("enter")) companyPeople.add(name);
            else companyPeople.remove(name);
        }

        String[] nameArr = companyPeople.toArray(new String[companyPeople.size()]);

        for (int i = nameArr.length-1; i >= 0; i--) {
            System.out.println(nameArr[i]);
        }
    }
}
