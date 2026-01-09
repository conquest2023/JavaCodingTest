//package datasturcture.realization;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class 수학문제 {
//
//
//    static  boolean check=false;
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int a = sc.nextInt();
//        List<Integer> list=new ArrayList<>();
//        sc.nextLine();
//        for (int i = 0; i < a; i++) {
//            int zero=0;
//
//            StringBuilder idx= new StringBuilder();
//            char[] s = sc.nextLine().toCharArray();
//            for (int j = 0; j < s.length; j++) {
//                if (s[j] ==48){
//                    checkString(j);
//                    zero+=1;
//                }
//                if(s[j] >=48 && s[j]<=57){
//                    zero=0;
//                    check=true;
//                    idx.append(s[j]);
//                }else if(check){
//                    list.add(Integer.valueOf(String.valueOf(idx)));
//                    idx=new StringBuilder();
//                }
//            }
//        }
//    }
//
//    static int checkString(int i){
//
//    }
//}
