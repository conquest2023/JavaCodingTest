package datasturcture.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class ISBN {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        String[] arr= (sc.next().split(""));
        boolean check=false;
        int result=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("*")){
                if(i%2==1){
                    check=true;
                }
                continue;
            }
            if (i%2==1){
                result+=Integer.valueOf(arr[i])*3;
            }else {

                result+=Integer.valueOf(arr[i]);
            }
        }
        if(result%10==0){
            System.out.println(0);
            return;
        }
        if (check){
            System.out.println((10-(result%10))/3);
        }else{
            System.out.println(10-(result%10));
        }
    }
}
