package datasturcture.realization;

import java.util.Scanner;

public class 기상캐스터 {

    static char[][] arr;

    static int[][] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();
        arr= new char[a][b];
        check=new int[a][b];
        for (int i = 0; i <a; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < b; j++) {
               arr[i][j]= s.charAt(j);
               if(s.charAt(j)=='c'){
                   check[i][j]=1;
               }
            }
        }
        for (int i = 0; i < a; i++) {
            int count=0;
            boolean idx=false;
            for (int j = 0; j <b ; j++) {
                if (check[i][j]==1){
                    count=0;
                    idx=true;
                    System.out.print(0+" ");
                    continue;
                }
                if(!idx && check[i][j]==0){
                    System.out.print(-1+" ");
                    continue;
                }else{
                    count+=1;
                    System.out.print(count+" ");
                }
            }
            System.out.println();
        }
    }
}
