package datasturcture.backtracking;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 보물섬 {

    static  String[][] arr;

    static int[][] visited;


    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};
    static  int a;

    static  int max;

    static  int b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.nextLine();
        arr=new String[a][b];
        visited=new int[a][b];
        for (int i = 0; i < a; i++) {
            String[] split = sc.nextLine().split("");
            for (int j = 0; j < split.length; j++) {
                arr[i][j]=split[j];
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(arr[i][j].equals("L")){
                    function(i,j);
                    visited=new int[a][b];
                }
            }
        }
        System.out.println(max-1);
    }
    static void function(int i ,int j) {
        visited[i][j] = 1;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        while (!deque.isEmpty()) {
            int[] poll = deque.pop();
            for (int k = 0; k < 4; k++) {
                int ny = poll[0] + dy[k];
                int nx = poll[1] + dx[k];

            if(nx<0 || ny<0 || nx>=b|| ny>=a )
                continue;

            if(visited[ny][nx]!=0){
                continue;
            }
            if(arr[ny][nx].equals("W")) {
                continue;
            }
            visited[ny][nx] = visited[poll[0]][poll[1]] + 1;
            deque.add(new int[]{ny,nx});
            if(max<visited[ny][nx]) {
                max=visited[ny][nx];
            }
            }
        }

    }

}
