
package bankstatementtcs;

import java.util.Scanner;

public class BankStatementTCS {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the interest per annum");
        float intann = scan.nextFloat();
        System.out.println("Enter the number of records");
        int T = scan.nextInt();
        int[][] report = new int[T-2][3];
        String[] credeb = new String[T-2];
        int missing= 0,tosub =0,amnt = 0;
        String cord="";
        boolean found = false;
        System.out.println("Enter the report in the order Transaction ID - amount - credit/debit - balance");
        for(int i =0;i<T-2;i++)
        {
            report[i][0] = scan.nextInt();
            report[i][1] = scan.nextInt(); //amount transacted
            credeb[i] = scan.next();
            report[i][2] = scan.nextInt();
            if(report[i][0] != (i+1) && found == false)
            {
                missing = report[i][0] -2;
                tosub = report[i][2];
                amnt = report[i][1];
                cord = credeb[i];
                found = true;
            }
        }
        System.out.println("Enter total interest gained for these days");
        double intgain = scan.nextDouble();
        double intpday = 0.0;
        for(int i=0;i<T-2;i++)
        {
            intpday = report[i][2]*(intann/36500);
            intgain-=intpday;
        }
        long lost = Math.round(intgain*36500/intann);
        int lost2 =0;
        if(cord.equals("credit"))
        {
            lost2 = tosub-amnt;
            System.out.println("Credit");
        }
        else
        {
            lost2 = tosub+amnt;
        }
        lost -=lost2;
        if(report[missing-2][2]> lost)
        {
            amnt = (int) (report[missing-2][2]-lost);
            cord = "debit";
        }
        else
        {
            amnt = (int) (lost-report[missing-2][2]);
            cord = "credit";
        }
        System.out.println(missing+" "+amnt+" "+cord+" "+lost);
        if(lost > lost2)
        {
            amnt = (int)(lost - lost2);
            cord = "debit";
        }
        else
        {
            amnt = (int) (lost2 - lost);
            cord = "credit";
        }
        System.out.println(missing+1+" "+amnt+" "+cord+" "+lost2);
    }
    
}
