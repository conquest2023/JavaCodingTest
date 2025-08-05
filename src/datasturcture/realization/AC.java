package datasturcture.realization;

import java.util.Arrays;
import java.util.Scanner;

public class AC {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < a; i++) {
            boolean check=true;
            int count=0;
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)=='D'){
                    count+=1;
                }
            }
            String b = sc.nextLine();
            StringBuilder sb =new  StringBuilder(sc.nextLine());

            // 대괄호 제거
            if (sb.charAt(0) == '[') {
                sb.deleteCharAt(0);
            }
            // 뒤에 ']' 제거
            if (sb.charAt(sb.length() - 1) == ']') {
                sb.deleteCharAt(sb.length() - 1);
            }
            String[] parts = sb.toString().split(",");
            StringBuilder result = new StringBuilder();
            for (String part : parts) {
                result.append(part.trim());
            }
            for (int j = 0; j < s.length(); j++) {
                if (sb.length()==0 || Integer.parseInt(b)<=count){
                    check=false;
                    break;
                }
                if (String.valueOf(s.charAt(j)).equals("D")){
                    result.deleteCharAt(0);
                }
                if (String.valueOf(s.charAt(j)).equals("R")){
                     result.reverse();
                }

            }
             if(check) {
                 StringBuilder stringBuilder=new StringBuilder();
                 for (int j = 0; j < result.length()-1; j++) {
                     stringBuilder.append(result.charAt(j)+",");
                 }
                 System.out.print("["+stringBuilder+(result.charAt(result.length()-1))+"]");
             }else{
                 System.out.println("error");
             }
        }
    }
}
