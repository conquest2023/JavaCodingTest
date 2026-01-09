package datasturcture.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class 유기농배추_dfs {


    static int[][] arr;

    static  int[][] visited;

    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};

    static  int width;

    static int height;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < a ; i++) {
            int count=0;
            int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();
            height=array[0];
            width=array[1];
            visited=new int[height][width];
            arr=new int[height][width];
            for (int j = 0; j <array[2] ; j++) {
                int[] spilt = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();
                arr[spilt[0]][spilt[1]]=1;
            }
            for (int s = 0; s <height; s++) {
                for (int k = 0; k < width; k++) {
                    if(arr[s][k]==1 && visited[s][k]==0){
                        dfs(s,k);
                        count+=1;
                    }
                }
            }
            System.out.println(count);
        }
    }


    static void dfs(int a,int b){
        visited[a][b]=1;
        for (int i = 0; i <4; i++) {
             int ny=a+dy[i];
             int nx=b+dx[i];
             if (ny<0 || nx <0 || ny>=height|| nx>=width)
                 continue;
             if (visited[ny][nx]==0 && arr[ny][nx]==1){
                 dfs(ny,nx);
             }
        }

    }
}
