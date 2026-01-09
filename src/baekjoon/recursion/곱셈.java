package datasturcture.recursion;

import java.util.Scanner;

public class 곱셈 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long a = (long) sc.nextInt();
        Long b = (long) sc.nextInt();
        Long c = (long) sc.nextInt();
        System.out.println(go(a,b,c));

    }

    static  Long go(long a,long b,long c){

        if (b==1){
            return a%c;
        }

        long rec=go(a,b/2,c);

        rec=(rec*rec)%c;

        if (b%2!=0)
            rec=(rec*a)%c;
        return rec;
    }
}
