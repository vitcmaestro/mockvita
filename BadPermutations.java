
package badpermutations;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BadPermutations {
    public static long permute(long n)
    {
        if(n == 1 || n == 0)
            return 1;
        else{
            return n*permute(n-1);
        }
    }
    public static long combos(long num)
    {
        if(num == 1)
        {
            return 1;
        }
        else
            return (permute(num)*num)+combos(num-1);
    }
     private static long findfact(long num) {
        long count =0;
        for(int j =1;j<= num;j++)
        {
            if(num%j == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
        System.out.println("Enter the number of test cases");
        long num,total,tosub,intersects;
        int T = Integer.parseInt(br.readLine());
        long count;
        for(int i =0;i<T;i++)
        {
            num = Integer.parseInt(br.readLine());
            num = findfact(num);
            if(num <3)
                System.out.println(0);
            else{
            total = permute(num);
            tosub = permute(num-1)*(num-1);
            intersects = combos(num-2);
            System.out.println(total-tosub+intersects);
            }
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

   
    
}
