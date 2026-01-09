package datasturcture.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class 치킨배달 {

    static int[][] arr;

    static  int a;

    static  int b;

    static  int step;

    static  int result;


    static int[][] visited;

    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.nextLine();
        result=0;
        arr=new int[a][a];
        step =0;
        visited=new int[a][a];
        for (int i = 0; i < a; i++) {
            int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();
            for (int j = 0; j < array.length; j++) {
                 arr[i][j]=array[j];
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                int count=0;
                int min=999999999;
                if(arr[i][j]==1){
                     solve(i,j,count,min);
                     result+=count;
                     visited=new int[a][b];
                     step=a*a-(a+b);
                }
            }
        }
        System.out.println(result);
    }
    static  int solve(int i,int j,int count,int min){
        visited[i][j]=1;
        if(step==a*a-(a+b)){
            return min;
        }
        count+=1;
        for (int k = 0; k < 4; k++) {
            int ny=i+dy[k];
            int nx=j+dx[k];
            if (nx<0 || ny <0 || ny>=a || nx>=b || visited[ny][nx]==1)
                continue;
            if (arr[ny][nx]==2){
                if (min>count){
                    min=count;
                    continue;
                }
            }

            solve(ny,nx,count,min);
            step+=1;
        }
        return min;
    }

}
