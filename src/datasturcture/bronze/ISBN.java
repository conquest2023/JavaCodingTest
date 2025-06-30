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
        int answer=0;
        while (true){
            if (check){
                if(((answer*3)+result)%10==0){
                    System.out.println(answer);
                    break;
                }

            }else{
                if((answer+result)%10==0){
                    System.out.println(answer);
                    break;
                }
            }
            answer++;

        }

    }
}
